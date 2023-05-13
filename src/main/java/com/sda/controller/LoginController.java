package com.sda.controller;

import com.sda.api.UserLoginData;
import com.sda.view.View;

public interface LoginController {

    View login(UserLoginData userLoginData);

}