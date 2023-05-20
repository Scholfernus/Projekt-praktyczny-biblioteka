package com.sda.service;

import com.sda.api.UserLoginData;
import com.sda.model.User;
import com.sda.dao.user.FileUserDao;
import com.sda.dao.user.UserProvider;
import com.sda.view.ActiveUserUtil;

public class UserService implements UserLoginChecker {

    private final UserProvider userProvider;

    public UserService() {
        userProvider = new FileUserDao();
    }

    public UserService(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public boolean checkLogin(UserLoginData userLoginData) {
        return userProvider.getAllUser().stream()
                .filter(user -> checkIfUserExist(
                        userLoginData, user))
                .filter(user -> checkIfUserPasswordIsCorrect(
                        userLoginData, user))
                .peek(ActiveUserUtil::setActiveUser)
                .findAny().isPresent();
    }

    private boolean checkIfUserPasswordIsCorrect(UserLoginData userLoginData,
                                                 User user) {
        return userLoginData.getPassword().equals(user.getPassword());
    }

    private boolean checkIfUserExist(UserLoginData userLoginData, User user) {
        return user.getLogin().equals(userLoginData.getLogin());
    }

}
