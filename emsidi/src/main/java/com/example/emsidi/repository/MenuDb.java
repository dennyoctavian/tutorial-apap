package com.example.emsidi.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emsidi.model.MenuModel;

@Repository
public interface MenuDb extends JpaRepository<MenuModel, Long>{
    Optional<MenuModel> findByNamaMenu(String nama);
    // Optional<MenuModel> findByNoCabangMenu(Long noCabang);
}
