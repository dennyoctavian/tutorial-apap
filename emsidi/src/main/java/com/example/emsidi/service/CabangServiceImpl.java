package com.example.emsidi.service;

import com.example.emsidi.model.CabangModel;
import com.example.emsidi.repository.CabangDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;

import java.time.LocalTime;
import java.time.ZoneId;

@Service
@Transactional
public class CabangServiceImpl implements CabangService{
    
    @Autowired
    CabangDb cabangDb;

    @Override
    public void addCabang(CabangModel cabang) {
        cabangDb.save(cabang);
    }

    @Override
    public void updateCabang(CabangModel cabang) {
        cabangDb.save(cabang);
    }

    

    @Override
    public List<CabangModel> getCabangList() {
        return cabangDb.findAll();
    }

    @Override
    public CabangModel getCabangByNoCabang(Long noCabang) {
        Optional<CabangModel> cabang = cabangDb.findByNoCabang(noCabang);
        if (cabang.isPresent()) {
            return cabang.get();
        }
        return null;
    }

    @Override
    public List<CabangModel> getCabangListSorted() {
        return cabangDb.findAll(sortByNameAsc());
    }

    private Sort sortByNameAsc() {
        return Sort.by(Sort.Direction.ASC, "namaCabang");
    }

    @Override
    public void removeCabang(CabangModel cabang){
        cabangDb.delete(cabang);
    }

    @Override
    public boolean cekStatusBuka(Long noCabang){
        Optional<CabangModel> cabang = cabangDb.findByNoCabang(noCabang);
        CabangModel cabangNow = cabang.get();
        if ((LocalTime.now(ZoneId.of("GMT+07:00")).isBefore(cabangNow.getWaktuBuka())) || (LocalTime.now(ZoneId.of("GMT+07:00")).isAfter(cabangNow.getWaktuTutup()))){
            
            return true;
        } else {
            return false;
        }
        
    }
}
