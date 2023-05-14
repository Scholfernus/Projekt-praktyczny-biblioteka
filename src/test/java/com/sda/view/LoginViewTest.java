package com.sda.view;

import com.sda.api.UserLoginData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LoginViewTest {
    private final UserLoginData exampleUserLoginData = new UserLoginData("testUser",
            "testPassword");
    @Test
    void test()throws FileNotFoundException {
        LoginView loginView = new LoginView(new File("src/main/resources/login_test_input"));

    assertThat(exampleUserLoginData).isEqualTo(loginView.getData());
    }
}
