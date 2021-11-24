package com.example.emsidi.service;

import com.example.emsidi.model.UserModel;
import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    void updateUser(UserModel myUser);
    public String encrypt(String password);
    public List<UserModel> getUserList();
    UserModel getUserByUsername(String username);
    // UserModel getUserNow();
    Boolean getMatchPassword(String passwordInput, String passwordDatabase);
    void removeUser(UserModel user);
}
