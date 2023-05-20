package com.sda.controller;

import com.sda.api.UserLoginData;
import com.sda.dao.user.FileUserDao;
import com.sda.dao.user.UserLoader;
import com.sda.model.User;
import com.sda.service.UserLoginChecker;
import com.sda.service.UserService;
import com.sda.view.LoginView;
import com.sda.view.MainMenuView;
import com.sda.view.View;

import java.util.Optional;

public class UserControllerImpl implements UserController {
    private final UserLoader userLoader;
    private final UserLoginChecker userLoginChecker;


    public UserControllerImpl() {
        this.userLoader = new FileUserDao();
        this.userLoginChecker = new UserService();
    }

    public UserControllerImpl(UserLoginChecker userLoginChecker) {
        this.userLoader = new FileUserDao();
        this.userLoginChecker = userLoginChecker;
    }

    @Override
    public View login(UserLoginData userLoginData) {
        if (userLoginChecker.checkLogin(userLoginData)) {
            return new MainMenuView();
        }
        return new LoginView(
                Optional.of("Podano niepoprawny login lub hasło")
        );
    }
    @Override
    public View addNewUser(User newUser) {
        userLoader.saveUser(newUser);
        return new MainMenuView();
    }
}