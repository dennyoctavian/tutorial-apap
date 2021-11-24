package com.example.emsidi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.example.emsidi.service.UserService;
import com.example.emsidi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.emsidi.model.RoleModel;
import com.example.emsidi.model.UserModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole",listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping(value = "/viewall")
    public String listUser(Model model){
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping(value = "/hapus/{username}")
    public String deletePegawaiForm(@PathVariable String username, Model model) {
        UserModel user = userService.getUserByUsername(username);
        List<UserModel> listUser = userService.getUserList();
        userService.removeUser(user);
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping(value = "/update-password")
    public String ubahPasswordForm(Model model){
        return "reset-password";
    }

    @PostMapping(value = "/update-password")
    public String ubahPassword(@ModelAttribute UserModel userModel, String username, String password, String newPassword, String konfirmasiPassword, Model model){
        UserModel myUser = userService.getUserByUsername(username);
        if (userService.getMatchPassword(password, myUser.getPassword())){
            if (newPassword.equals(konfirmasiPassword)){
                System.out.println("Password Konfirmasi Sama");
                String newPasswordHash = userService.encrypt(newPassword);
                myUser.setPassword(newPasswordHash);
                userService.updateUser(myUser);
                model.addAttribute("message", "password berhasil diubah");
            }else {
                model.addAttribute("message", "password tidak sama");
            }
        }else {
            model.addAttribute("message", "password salah");
        }
        return "reset-password-status";
    }
}
