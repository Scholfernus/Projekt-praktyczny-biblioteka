package com.sda.provider;

import com.sda.model.Address;
import com.sda.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static com.sda.model.Role.ADMIN;
import static com.sda.model.Role.USER;

class FileUserProviderTest {
    Set<User> expectedData = Set.of(
            new User("Jan",
                    "Nowak",
                    "jano",
                    "jano@gmail.com",
                    "password123",
                    new Address(
                            "Wiejska",
                            "16",
                            "",
                            "01-256"),
                    List.of(USER, ADMIN)
            ),
            new User("Adam",
                    "Kowalski",
                    "adko",
                    "adko@gmail.com",
                    "password345",
                    new Address(
                            "Inna",
                            "5",
                            "2",
                            "01-256"
                    ),
                    List.of(USER)
            )
    );

    @Test
    void shouldProvideAndMapAllUsersFromFile() {
        //given
        UserProvider userProvider = new FileUserProvider("src/test/resources/test_users");
        //when
        Set<User> result = userProvider.getAllUser();
        //then
        assertThat(result).containsAll(expectedData);
    }
}