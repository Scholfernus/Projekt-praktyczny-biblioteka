package com.sda.controller;

import com.sda.api.UserLoginData;
import com.sda.model.User;
import com.sda.view.View;

public interface UserController {

    View login(UserLoginData userLoginData);

    View addNewUser(User newUser);


}