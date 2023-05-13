package com.sda.service;

import com.sda.api.UserLoginData;

public interface UserLoginChecker {

    boolean checkLogin  (UserLoginData userLoginData);
}
