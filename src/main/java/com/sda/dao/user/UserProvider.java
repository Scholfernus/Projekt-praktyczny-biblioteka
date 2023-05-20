package com.sda.dao.user;

import com.sda.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserProvider {

    Set<User> getAllUser();

    Optional<User> getByLogin(String login);
}