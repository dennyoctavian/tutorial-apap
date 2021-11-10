package com.example.emsidi.service;

import com.example.emsidi.model.MenuModel;

import java.util.List;

public interface MenuService {
    List<MenuModel> getListMenu();
    void addMenu(MenuModel menu);
    // MenuModel getListMenuByNoCabang(Long noCabang);
}
