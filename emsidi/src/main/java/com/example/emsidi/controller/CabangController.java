package com.example.emsidi.controller;

import com.example.emsidi.model.CabangModel;
import com.example.emsidi.model.PegawaiModel;
import com.example.emsidi.model.MenuModel;
import com.example.emsidi.service.CabangService;
import com.example.emsidi.service.MenuService;
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

    @Qualifier("menuServiceImpl")
    @Autowired
    private MenuService menuService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model){
        CabangModel cabang = new CabangModel();
        List<MenuModel> listMenu = menuService.getListMenu();
        List<MenuModel> listMenuNew = new ArrayList<>();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenuExisting", listMenu);
        model.addAttribute("listMenuNew", listMenuNew);
        return "form-add-cabang";
    }

    @PostMapping(value = "/cabang/add", params = {"addRow"})
    private String addRowCabangMultiple(@ModelAttribute CabangModel cabang, Model model) {
        if (cabang.getListMenu() == null || cabang.getListMenu().size() == 0) {
            cabang.setListMenu(new ArrayList<>());
        }
        cabang.getListMenu().add(new MenuModel());
        List<MenuModel> listMenu = menuService.getListMenu();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenuExisting", listMenu);
        return "form-add-cabang";
    }

    //implementasi disini
    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            @ModelAttribute MenuModel menu,
            Model model
    ) {
        // System.out.println(menus);
        cabangService.addCabang(cabang);
        // menuService.addMenu(menu);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @RequestMapping(value = "/tambah-row/{banyakRow}", method= RequestMethod.POST)
    public String addRow(@ModelAttribute CabangModel cabang, Model model, @PathVariable Long banyakRow) {
        model.addAttribute("cabang", cabang);
        model.addAttribute("banyakRow", banyakRow+1);
        model.addAttribute("listMenu", menuService.getListMenu());
        return "form-add-cabang";
    }

    @PostMapping("/hapus-row")
    public String removeRow(@ModelAttribute CabangModel cabang, Model model){
        model.addAttribute("cabang", cabang);
        return "form-add-cabang";
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
        List<MenuModel> listMenu = cabang.getListMenu();
        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        model.addAttribute("listMenu", listMenu);
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
