package com.sda.service;

import com.sda.api.UserLoginData;
import com.sda.model.User;

import java.util.Optional;

public interface UserLoginChecker {

    boolean checkLogin(UserLoginData userLoginData);

}