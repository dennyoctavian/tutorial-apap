package com.example.emsidi.service;

import com.example.emsidi.model.PegawaiModel;
import com.example.emsidi.repository.PegawaiDb;
import com.example.emsidi.rest.Setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ArrayList;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
    @Autowired
    private PegawaiDb pegawaiDb;

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai) {
        return pegawaiDb.save(pegawai);
    }

    @Override
    public List<PegawaiModel> retrieveListPegawai() {
        return pegawaiDb.findAll();
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);

        if(pegawai.isPresent()) {
            return pegawai.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate) {
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        pegawai.setCabang(pegawaiUpdate.getCabang());
        pegawai.setJenisKelamin(pegawaiUpdate.getJenisKelamin());
        pegawai.setNamaPegawai(pegawaiUpdate.getNamaPegawai());
        return pegawaiDb.save(pegawai);
    }

    @Override
    public void deletePegawai(Long noPegawai) {
        
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        
        pegawaiDb.delete(pegawai);
        
    }

    @Override
    public List<PegawaiModel> getPegawaiByHurufAwal(String horufAwal){
       List<PegawaiModel> listPegawai = pegawaiDb.findAll();
       List<PegawaiModel> listPegawaiByHuruf = new ArrayList<PegawaiModel>();
       for (PegawaiModel model : listPegawai){
           String namaPegawai = model.getNamaPegawai();
           if (String.valueOf(namaPegawai.charAt(0)).equals(horufAwal)){
                listPegawaiByHuruf.add(model);
           }
       }
       return listPegawaiByHuruf;
    }
}
