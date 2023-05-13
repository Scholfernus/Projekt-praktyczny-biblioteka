package com.sda.service;

import com.sda.api.UserLoginData;
import com.sda.model.User;
import com.sda.provider.FileUserProvider;
import com.sda.provider.UserProvider;

public class UserService implements UserLoginChecker{
  private UserProvider userProvider;

    public UserService() {
        userProvider = new FileUserProvider();
    }

    public UserService(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public boolean checkLogin(UserLoginData userLoginData) {
        return userProvider.getAllUser().stream().filter(user -> checkIfUserExist(userLoginData,user))
                .anyMatch(user -> userLoginData.getPassword().equals(user.getPassword()));

    }
    private boolean checkIfUserExist(UserLoginData userLoginData, User user){
        return user.getLogin().equals((userLoginData.getLogin()));
    }

}