package com.sda.provider;

import com.sda.model.User;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.sda.UserDataFactory.getExampleUserData;
import static org.assertj.core.api.Assertions.assertThat;

class FileUserProviderTest {

    @Test
    void shouldProvideAndMapAllUsersFromFile() {
        //given
        UserProvider userProvider = new FileUserProvider("src/test/resources/test_users");
        //when
        Set<User> result = userProvider.getAllUser();
        //then
        assertThat(result).containsAll(getExampleUserData());
    }

}