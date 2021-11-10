package com.example.emsidi.restcontroller;

import com.example.emsidi.model.CabangModel;
import com.example.emsidi.model.PegawaiModel;
import com.example.emsidi.service.PegawaiRestService;
import com.example.emsidi.service.CabangRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import com.example.emsidi.rest.Setting;
import java.time.LocalTime;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class PegawaiRestController {
    private WebClient webClient;
    @Autowired
    private PegawaiRestService pegawaiRestService;

    @Autowired
    private CabangRestService cabangRestService;

    @PostMapping(value = "/pegawai")
    private PegawaiModel createPegawai(@Valid @RequestBody PegawaiModel pegawai, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );
        } else {
            return pegawaiRestService.createPegawai(pegawai);
        }
    }

    @GetMapping(value="/pegawai/{noPegawai}")
    private PegawaiModel retrievePegawai(@PathVariable("noPegawai") Long noPegawai) {
        try {
            return pegawaiRestService.getPegawaiByNoPegawai(noPegawai);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Pegawai" + String.valueOf(noPegawai) + "Not Found."
            );
        }
    }

    @DeleteMapping(value = "/pegawai/{noPegawai}")
    private ResponseEntity deletePegawai(@PathVariable("noPegawai") Long noPegawai) {
        try {
            pegawaiRestService.deletePegawai(noPegawai);
            return ResponseEntity.ok("Pegawai with ID" + String.valueOf(noPegawai) + " Deleted!");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Pegawai with ID" + String.valueOf(noPegawai) + " Not Found!"
            );
        } catch (UnsupportedOperationException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Pegawai is still open or has pegawai!"
            );
        }
    }

    @PutMapping(value="/pegawai/{noPegawai}")
    private PegawaiModel updatePegawai(@PathVariable("noPegawai") Long noPegawai, @RequestBody PegawaiModel pegawai) {
        try {
            return pegawaiRestService.updatePegawai(noPegawai, pegawai);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Pegawai with ID" + String.valueOf(noPegawai) + " Not Found!"
            );
        }
    }

    @GetMapping(value="/list-pegawai")
    private List<PegawaiModel> retrieveListPegawai() { return pegawaiRestService.retrieveListPegawai();}

    @GetMapping(value="/pegawai/umur/{noPegawai}")
    private HashMap<String, String> preksiUmurPegawai(@PathVariable("noPegawai") Long noPegawai) {
        try {
            PegawaiModel pegawai = pegawaiRestService.getPegawaiByNoPegawai(noPegawai);
            String nama = pegawai.getNamaPegawai();
            LocalTime now = LocalTime.now();
            Long noCabang = pegawai.getCabang().getNoCabang();
            CabangModel cabang = cabangRestService.getCabangByNoCabang(noCabang);
            HashMap<String, String> response2 = new HashMap<>();
            if (now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())) {
                String[] arr = nama.split(" ");
                String namaPrediksi = arr[0];
                String uri = "https://api.agify.io?name="+namaPrediksi;
                RestTemplate restTemplate = new RestTemplate();
                String hasil = restTemplate.getForObject(uri, String.class);
                System.out.println(hasil);
                String[] object = hasil.split(",");
                String[] age = object[1].split(":");
                response2.put("noPegawai", Long.toString(pegawai.getNoPegawai()));
                response2.put("namaPegawai", pegawai.getNamaPegawai());
                response2.put("jenisKelamin", String.valueOf(pegawai.getJenisKelamin()));
                response2.put("umur", age[1]);
                return response2;
            } else {
                throw new UnsupportedOperationException();
            }
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Pegawai" + String.valueOf(noPegawai) + "Not Found."
            );
        }
        
    }
}
