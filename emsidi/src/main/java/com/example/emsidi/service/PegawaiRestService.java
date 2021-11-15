package com.example.emsidi.service;

import com.example.emsidi.model.PegawaiModel;
import java.util.List;

public interface PegawaiRestService {
    PegawaiModel createPegawai(PegawaiModel pegawai);
    List<PegawaiModel> retrieveListPegawai();
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
    List<PegawaiModel> getPegawaiByHurufAwal(String horufAwal);
    PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate);
    void deletePegawai(Long noPegawai);
}
