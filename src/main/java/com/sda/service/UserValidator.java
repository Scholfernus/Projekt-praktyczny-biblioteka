package com.sda.service;

import com.sda.dao.user.FileUserDao;
import com.sda.dao.user.UserProvider;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Pattern;

public class UserValidator {
    UserProvider userProvider;
    private final static String POSTAL_CODE_REGEX = "^[0-9]{2}-[0-9]{3}";

    public UserValidator(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    public UserValidator() {
        this.userProvider = new FileUserDao();
    }

    public boolean validateUserLogin(String login) {
        return userProvider.getByLogin(login).isEmpty();
    }

    public boolean validateUserEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    public boolean validateUserPostCode(String postCode) {
        return Pattern.matches(POSTAL_CODE_REGEX, postCode);
    }
}
