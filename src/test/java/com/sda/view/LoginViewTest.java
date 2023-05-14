package com.sda.view;

import com.sda.api.UserLoginData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {

    private final UserLoginData exampleUserLoginData = new UserLoginData(
            "testUser",
            "testPassword"
    );

    @Test
    void shouldProvideUserLoginDataBasedOnScannerInput() throws FileNotFoundException {
        LoginView loginView = new LoginView(
                new File("src/test/resources/login_test_input")
        );
        Assertions.assertThat(exampleUserLoginData).isEqualTo(loginView.getData());
    }
}