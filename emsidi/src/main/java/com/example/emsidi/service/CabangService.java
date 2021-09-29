package com.example.emsidi.service;

import com.example.emsidi.model.CabangModel;
import java.util.List;


public interface CabangService {
    void addCabang(CabangModel cabang);
    void updateCabang(CabangModel cabang);
    
    List<CabangModel> getCabangList();
    List<CabangModel> getCabangListSorted();
    CabangModel getCabangByNoCabang(Long noCabang);
    void removeCabang(CabangModel cabang);
    boolean cekStatusBuka(Long noCabang);
    
}
