package com.example.emsidi.service;
import com.example.emsidi.model.PegawaiModel;
// import java.util.Optional;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);
    void updatePegawai(PegawaiModel pegawai);
    void removePegawai(PegawaiModel pegawai);
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
    // Optional<PegawaiModel> findByNoCabang(Long noCabang);

}
