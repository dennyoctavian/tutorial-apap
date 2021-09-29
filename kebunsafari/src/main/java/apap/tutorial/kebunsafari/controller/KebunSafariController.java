package apap.tutorial.kebunsafari.controller;
import apap.tutorial.kebunsafari.model.KebunSafariModel;
import apap.tutorial.kebunsafari.service.KebunSafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/")
    public String listKebunSafari(Model model){
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();
        model.addAttribute("listKebunSafari", listKebunSafari);

        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById (@RequestParam(value = "id", required = true) String idKebunSafari, Model model) {
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        model.addAttribute("kebunSafari", kebunSafari);

        return "detail-kebun-safari";
    }

    // @RequestMapping("/kebun-safari/add")
    // public String addKebunSafari(
    //     @RequestParam(value="id", required = true) String idKebunSafari,
    //     @RequestParam(value="nama", required = true) String namaKebunSafari, 
    //     @RequestParam(value="alamat", required = true) String alamat,
    //     @RequestParam(value="noTelepon", required = true) String noTelepon,
    //     Model model
    // ) {
    //     KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

    //     kebunSafariService.addKebunSafari(kebunSafari);

    //     model.addAttribute("kebunSafari", kebunSafari);

    //     return "add-kebun-safari";
    // }

    @GetMapping(value = "/kebun-safari/view/{id}")
    public String getKebunSafari(
        @PathVariable(value = "id") String id, Model model){
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(id);
        model.addAttribute("kebunSafari", kebunSafari);

        return "detail-kebun-safari";
    }

    @GetMapping(value="/kebun-safari/update/{id}")
    public String updateValue(@RequestParam(value="noTelepon", required = true) String noTelepon, @PathVariable(value = "id") String id, Model model) {
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(id);
        kebunSafari.setNoTelepon(noTelepon);
        model.addAttribute("kebunSafari", kebunSafari);
        return "updated-kebun-safari";

    }

    @GetMapping(value="/kebun-safari/delete/{id}")
    public String deleteObjectById(@PathVariable(value = "id") String id, Model model) {
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(id);
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();
        if (listKebunSafari != null) {
            return "delete-gagal";
        }
        listKebunSafari.remove(kebunSafari);
        return "delete-object";
    }

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafariNoAlamat(
        @RequestParam(value="id", required = true) String idKebunSafari,
        @RequestParam(value="nama", required = true) String namaKebunSafari, 
        @RequestParam(value="alamat", required = false) String alamat,
        @RequestParam(value="noTelepon", required = true) String noTelepon,
        Model model
    ) {
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        kebunSafariService.addKebunSafari(kebunSafari);

        model.addAttribute("kebunSafari", kebunSafari);

        return "add-kebun-safari";
    }



}
