package com.sda.controller;

import com.sda.UserDataFactory;
import com.sda.api.UserLoginData;
import com.sda.service.UserService;
import com.sda.view.LoginView;
import com.sda.view.MainMenuView;
import com.sda.view.View;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoginControllerImplTest {

    private static final String CORRECT_LOGIN = "jano";
    private static final String CORRECT_PASSWORD = "password123";
    private static final String INCORRECT_LOGIN = "incorrectLogin";
    private static final String INCORRECT_PASSWORD = "incorrectPassword";

    @Test
    void whenUserLoginDataIsCorrectShouldReturnMainMenuView() {
        //given
        LoginController loginController = new LoginControllerImpl(
                new UserService(UserDataFactory::getExampleUserData)
        );
        //when
        View result = loginController.login(new UserLoginData(
                CORRECT_LOGIN, CORRECT_PASSWORD));
        //then
        assertThat(result).isInstanceOf(MainMenuView.class);
    }

    @Test
    void whenLoginDoesNotExistShouldReturnLoginView() {
        //given
        LoginController loginController = new LoginControllerImpl(
                new UserService(UserDataFactory::getExampleUserData)
        );
        //when
        View result = loginController.login(new UserLoginData(
                INCORRECT_LOGIN, ""));
        //then
        assertThat(result).isInstanceOf(LoginView.class);
    }

    @Test
    void whenLoginExistButPasswordIsIncorrectShouldReturnLoginView() {
        //given
        LoginController loginController = new LoginControllerImpl(
                new UserService(UserDataFactory::getExampleUserData)
        );
        //when
        View result = loginController.login(new UserLoginData(
                CORRECT_LOGIN, INCORRECT_PASSWORD));
        //then
        assertThat(result).isInstanceOf(LoginView.class);
    }

}