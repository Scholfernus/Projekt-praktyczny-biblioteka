package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private Address address;
    private List<Role> roles;

    public String parseToFileFormat() {
        return firstName + ";" + lastName + ";" + login + ";" + email +
                ";" + password + ";" + address.parseToFileFormat() + ";" +
                StringUtils.join(roles, "/");
    }

    private String map(List<Role> roles) {
        StringBuilder sb = new StringBuilder();
        roles.forEach(role -> sb.append(role + "/"));
        return sb.substring(0, sb.length() - 1);
    }
}