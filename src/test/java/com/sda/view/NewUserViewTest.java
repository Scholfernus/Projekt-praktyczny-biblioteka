package com.sda.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class NewUserViewTest {

    NewUserView newUserView = new NewUserView(new File("src/test/resources/non_existing_login"));

    NewUserViewTest() throws FileNotFoundException {
    }

    @Test
    void test() {
        // given
        String existingLogin = "jano";
        // when
        String result = newUserView.loginCheck(existingLogin);
        // then
        Assertions.assertThat(result).isEqualTo("sda");

    }

}