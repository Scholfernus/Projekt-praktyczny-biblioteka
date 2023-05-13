package com.sda.controller;

import com.sda.api.UserLoginData;
import com.sda.service.UserLoginChecker;
import com.sda.service.UserService;
import com.sda.view.LoginView;
import com.sda.view.MainMenuView;
import com.sda.view.View;

import java.util.Optional;


public class LoginControllerImpl implements LoginController {
    public LoginControllerImpl(UserLoginChecker userLoginChecker) {
        this.userLoginChecker = userLoginChecker;
    }

    private UserLoginChecker userLoginChecker;

    public LoginControllerImpl() {
        this.userLoginChecker = new UserService();
    }

    @Override
    public View login(UserLoginData userLoginData) {
        if (userLoginChecker.checkLogin(userLoginData)) {
            return new MainMenuView();
        }
        return new LoginView(Optional.of("Podano niepoporawny login lub hasło"));
    }
}
