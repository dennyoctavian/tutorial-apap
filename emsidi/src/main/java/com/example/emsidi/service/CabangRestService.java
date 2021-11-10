package com.example.emsidi.service;

import reactor.core.publisher.Mono;
import com.example.emsidi.model.CabangModel;
import com.example.emsidi.rest.CabangDetail;
import java.util.List;

public interface CabangRestService {
    CabangModel createCabang(CabangModel cabang);
    List<CabangModel> retrieveListCabang();
    CabangModel getCabangByNoCabang(Long noCabang);
    CabangModel updateCabang(Long noCabang, CabangModel cabangUpdate);
    void deleteCabang(Long noCabang);
    Mono<String> getStatus(Long noCabang);
    Mono<CabangDetail> postStatus();

}
