package com.example.emsidi.controller;

import com.example.emsidi.model.CabangModel;
import com.example.emsidi.model.PegawaiModel;
import com.example.emsidi.service.CabangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;

@Controller
public class CabangController {

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model){
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model){
        List<CabangModel> listCabang = cabangService.getCabangList();
        List<Boolean> statusTutup = new ArrayList<Boolean>();
        //status tutupnya yang true
        for (CabangModel cabang : listCabang){
            boolean tutup = cabangService.cekStatusBuka(cabang.getNoCabang());
            statusTutup.add(tutup);
        }
        model.addAttribute("listCabang", listCabang);
        model.addAttribute("statusTutup", statusTutup);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(
            @RequestParam(value = "noCabang") Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        if (cabang == null) {
            return "cabang-no-found";
        }
        List<PegawaiModel> listPegawai = cabang.getListPegawai();
        Boolean statusTutup = cabangService.cekStatusBuka(noCabang);
        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        model.addAttribute("statusTutup", statusTutup);
        return "view-cabang";
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
            @PathVariable Long noCabang,
            Model model
    ) {
        if(cabangService.cekStatusBuka(noCabang) == false){
            return "tidak-bisa-update-cabang";
        }
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", cabang);
        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "update-cabang";
    }

    @GetMapping("/cabang/viewallsorted")
    public String listCabangSorted(Model model){
        List<CabangModel> listCabang = cabangService.getCabangListSorted();
        List<Boolean> statusTutup = new ArrayList<Boolean>();
        //status tutupnya yang true
        for (CabangModel cabang : listCabang){
            Boolean status = cabangService.cekStatusBuka(cabang.getNoCabang());
            statusTutup.add(status);
        }
        model.addAttribute("listCabang", listCabang);
        model.addAttribute("statusTutup", statusTutup);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/delete/{noCabang}")
    public String deletePegawaiForm(@PathVariable Long noCabang, Model model) {
        if(cabangService.cekStatusBuka(noCabang) == false){
            return "tidak-bisa-delete-cabang";
        }
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        if (listPegawai.size() != 0) {
            return "error-remove-cabang";
        } else {
            cabangService.removeCabang(cabang);
        }
        
        List<CabangModel> listCabang = cabangService.getCabangList();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

}
