package com.sda.dao;

import com.sda.dao.user.FileUserDao;
import com.sda.dao.user.UserProvider;
import com.sda.model.User;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Set;

import static com.sda.UserDataFactory.getExampleUserData;
import static org.assertj.core.api.Assertions.assertThat;

class FileUserDaoTest {

    @Test
    void shouldProvideAndMapAllUsersFromFile() {
        //given
        UserProvider userProvider = new FileUserDao("src/test/resources/test_users");
        //when
        Set<User> result = userProvider.getAllUser();
        //then
        assertThat(result).containsAll(getExampleUserData());
    }

}