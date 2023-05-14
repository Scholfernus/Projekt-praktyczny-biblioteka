package com.sda.provider;

import com.sda.model.User;

import java.util.Set;

public interface UserProvider {

    Set<User> getAllUser();

}