package com.sda.provider;

import com.sda.model.Address;
import com.sda.model.Role;
import com.sda.model.User;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class FileUserProvider implements UserProvider {

    private String filePath = "src/main/resources/users";

    public FileUserProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Set<User> getAllUser() {
        Set<User> users = Set.of();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            users = bufferedReader.lines()
                    .map(this::mapToUser)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User mapToUser(String userDataLine) {
        String[] splitUserData = userDataLine.split(";");
        return User.builder()
                .firstName(splitUserData[0])
                .lastName(splitUserData[1])
                .login(splitUserData[2])
                .email(splitUserData[3])
                .password(splitUserData[4])
                .address(mapToAddress(splitUserData))
                .roles(mapToRoles(splitUserData))
                .build();
    }

    private Address mapToAddress(String[] splitUserData) {
        return Address.builder()
                .street(splitUserData[5])
                .buildingNo(splitUserData[6])
                .apartmentNo(splitUserData[7])
                .postalCode(splitUserData[8])
                .build();
    }

    private List<Role> mapToRoles(String[] splitUserData) {
        return Arrays.stream(splitUserData[9].split("/"))
                .map(Role::valueOf)
                .collect(Collectors.toList());
    }
}