package com.example.emsidi.service;

import com.example.emsidi.model.PegawaiModel;
import com.example.emsidi.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {
    @Autowired
    PegawaiDb pegawaiDb;

    @Override
    public void addPegawai(PegawaiModel pegawai) {
        pegawaiDb.save(pegawai);
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai){
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);
        if (pegawai.isPresent()) {
            return pegawai.get();
        }
        return null;
    }

    @Override
    public void updatePegawai(PegawaiModel pegawai) {
        pegawaiDb.save(pegawai);
    }

    @Override
    public void removePegawai(PegawaiModel pegawai){
        pegawaiDb.delete(pegawai);
    }

    
}
