package com.sda.dao.user;

import com.sda.model.Address;
import com.sda.model.Role;
import com.sda.model.User;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class FileUserDao implements UserProvider, UserLoader {

    private String filePath = "src/main/resources/users";

    public FileUserDao(String filePath) {
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

    @Override
    public Optional<User> getByLogin(String login) {
        return getAllUser().stream().filter(user -> user.getLogin().equals(login)).findAny();
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

    @Override
    public void saveUser(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.newLine();
            bufferedWriter.write(user.parseToFileFormat());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}