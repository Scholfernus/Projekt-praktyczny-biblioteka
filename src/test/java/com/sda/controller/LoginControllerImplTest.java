package com.sda.controller;

import com.sda.provider.UserDataFactory;
import com.sda.service.UserService;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerImplTest {
    void test() {

        // given
        LoginController loginController = new LoginControllerImpl(
                new UserService(UserDataFactory::)
        );
        // when

        // then
    }
}
