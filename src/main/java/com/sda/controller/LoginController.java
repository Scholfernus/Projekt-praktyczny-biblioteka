package com.sda.controller;

import com.sda.api.UserLoginData;

import javax.swing.text.View;

public interface LoginController {
    View login(UserLoginData userLoginData);
}
