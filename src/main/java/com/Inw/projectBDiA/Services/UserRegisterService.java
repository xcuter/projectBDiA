package com.Inw.projectBDiA.Services;

import com.Inw.projectBDiA.DAOs.User.UserDao;
import com.Inw.projectBDiA.Models.User;
import com.Inw.projectBDiA.Models.UserRegistration;
import com.google.common.hash.Hashing;


import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class UserRegisterService {
    private UserDao usDAO = new UserDao();
    public void register(UserRegistration userRegistration) {
        User userToRegister = UserMapper.map(userRegistration);
        try {
           hashPasswordWithSha256(userToRegister);
           usDAO.save(userToRegister);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void hashPasswordWithSha256(User userToRegister) {
        String passwordSha256 = Hashing.sha256().hashString(userToRegister.getPassword(), StandardCharsets.UTF_8).toString();
        userToRegister.setPassword(passwordSha256);
    }

    private static class UserMapper {
        static User map(UserRegistration userRegistration){
            return new User(
                    userRegistration.getFirstName(),
                    userRegistration.getLastName(),
                    userRegistration.getEmail(),
                    userRegistration.getPassword()
            );
        }
    }
}
