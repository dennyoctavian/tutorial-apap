package com.example.emsidi.service;

import com.example.emsidi.model.MenuModel;
import com.example.emsidi.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuDb menuDb;

    @Override
    public List<MenuModel> getListMenu() {
        return menuDb.findAll();
    }

    @Override
    public void addMenu(MenuModel menu){
        menuDb.save(menu);
    }
}
