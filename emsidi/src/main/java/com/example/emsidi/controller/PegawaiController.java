package com.example.emsidi.controller;

import com.example.emsidi.model.CabangModel;
import com.example.emsidi.model.PegawaiModel;
import com.example.emsidi.service.CabangService;
import com.example.emsidi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class PegawaiController {
    @Qualifier("pegawaiServiceImpl")
    @Autowired
    PegawaiService pegawaiService;

    @Qualifier("cabangServiceImpl")
    @Autowired
    CabangService cabangService;

    @GetMapping("/pegawai/add/{noCabang}")
    public String addPegawaiForm(@PathVariable Long noCabang, Model model) {
        PegawaiModel pegawai = new PegawaiModel();
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);
        return "form-add-pegawai";
    }

    @PostMapping("/pegawai/add")
    public String addPegawaiSubmit(
        @ModelAttribute PegawaiModel pegawai,
        Model model
    ) {
        pegawaiService.addPegawai(pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "add-pegawai";
    }

    @GetMapping("/pegawai/{noCabang}/{noPegawai}")
    public String addPegawaiForm(@PathVariable Long noCabang, @PathVariable Long noPegawai, Model model) {
        if(cabangService.cekStatusBuka(noCabang) == false){
            return "tidak-bisa-update-pegawai";
        }
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);
        return "form-update-pegawai";
    }

    @PostMapping("/pegawai/update/{noPegawai}")
    public String updatePegawaiSubmit(
        @PathVariable Long noPegawai,
        @ModelAttribute PegawaiModel pegawai,
        Model model
    ) {
        PegawaiModel pegawai_tersedia = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        pegawai_tersedia.setNamaPegawai(pegawai.getNamaPegawai());
        pegawai_tersedia.setJenisKelamin(pegawai.getJenisKelamin());
        pegawaiService.updatePegawai(pegawai_tersedia);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "update-pegawai";
    }

    @GetMapping("/pegawai/delete/{noCabang}/{noPegawai}")
    public String deletePegawaiForm(@PathVariable Long noCabang, @PathVariable Long noPegawai, Model model) {
        if(cabangService.cekStatusBuka(noCabang) == false){
            return "tidak-bisa-delete-pegawai";
        }
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        pegawaiService.removePegawai(pegawai);
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        return "view-cabang";
    }

    
}
