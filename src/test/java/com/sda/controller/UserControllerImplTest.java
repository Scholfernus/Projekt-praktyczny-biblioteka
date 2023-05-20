package com.sda.controller;

import com.sda.UserDataFactory;
import com.sda.api.UserLoginData;
import com.sda.model.User;
import com.sda.dao.user.UserProvider;
import com.sda.service.UserService;
import com.sda.view.LoginView;
import com.sda.view.MainMenuView;
import com.sda.view.View;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class UserControllerImplTest {

    private static final String CORRECT_LOGIN = "jano";
    private static final String CORRECT_PASSWORD = "password123";
    private static final String INCORRECT_LOGIN = "incorrectLogin";
    private static final String INCORRECT_PASSWORD = "incorrectPassword";
    UserProvider userProvider = new UserProvider() {
        @Override
        public Set<User> getAllUser() {
            return UserDataFactory.getExampleUserData();
        }

        @Override
        public Optional<User> getByLogin(String login) {
            return Optional.empty();
        }
    };

    @Test
    void whenUserLoginDataIsCorrectShouldReturnMainMenuView() {


        //given
        UserController userController = new UserControllerImpl(
                new UserService(userProvider)
        );
        //when
        View result = userController.login(new UserLoginData(
                CORRECT_LOGIN, CORRECT_PASSWORD));
        //then
        assertThat(result).isInstanceOf(MainMenuView.class);
    }

    @Test
    void whenLoginDoesNotExistShouldReturnLoginView() {
        //given
        UserController userController = new UserControllerImpl(
                new UserService(userProvider)
        );
        //when
        View result = userController.login(new UserLoginData(
                INCORRECT_LOGIN, ""));
        //then
        assertThat(result).isInstanceOf(LoginView.class);
    }

    @Test
    void whenLoginExistButPasswordIsIncorrectShouldReturnLoginView() {
        //given
        UserController userController = new UserControllerImpl(
                new UserService(userProvider)
        );
        //when
        View result = userController.login(new UserLoginData(
                CORRECT_LOGIN, INCORRECT_PASSWORD));
        //then
        assertThat(result).isInstanceOf(LoginView.class);
    }

}