package com.example.emsidi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.emsidi.repository.UserDb;
import com.example.emsidi.model.UserModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return  hashedPassword;
    }

    @Override
    public List<UserModel> getUserList(){ return userDb.findAll();}

    @Override
    public UserModel getUserByUsername(String username) {
        UserModel user = userDb.findByUsername(username);
        return user;
    }

    @Override
    public void removeUser(UserModel user) {
        userDb.delete(user);
    }

    @Override
    public Boolean getMatchPassword(String passwordInput, String passwordDatabase){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isPasswordMatches = passwordEncoder.matches(passwordInput, passwordDatabase);
        return isPasswordMatches;
    }

    @Override
    public void updateUser(UserModel myUser){
        userDb.save(myUser);
    }

    // @Override
    // public UserModel getUserNow(){
    //     return userDb.
    // }
}
