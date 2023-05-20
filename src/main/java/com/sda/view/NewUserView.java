package com.sda.view;

import com.sda.controller.UserController;
import com.sda.controller.UserControllerImpl;
import com.sda.model.Address;
import com.sda.model.Role;
import com.sda.model.User;
import com.sda.service.UserValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class NewUserView implements View {
    private Scanner input;
    private UserValidator userValidator;
    private UserController userController;

    public NewUserView() {
        this.input = new Scanner(System.in);
        this.userValidator = new UserValidator();
        this.userController = new UserControllerImpl();
    }

    public NewUserView(File file) throws FileNotFoundException {
        this.input = new Scanner(file);
        this.userValidator = new UserValidator();
        this.userController = new UserControllerImpl();
    }

    @Override
    public void display() {
        userController.addNewUser(getUserData()).display();
    }

    private User getUserData() {
        System.out.println("Podaj swoje imię: ");
        String firstName = input.nextLine();
        System.out.println("Podaj nazwisko: ");
        String lastName = input.nextLine();
        System.out.println("Podaj login: ");
        String login = loginCheck(input.nextLine());
        System.out.println("Podaj email: ");
        String email = emailCheck(input.nextLine());
        System.out.println("Podaj hasło: ");
        String password = input.nextLine();
        System.out.println("Podaj ulicę: ");
        String street = input.nextLine();
        System.out.println("Podaj nr budynku: ");
        String buildingNo = input.nextLine();
        System.out.println("Podaj nr mieszkania - opcjonalnie: ");
        String apartmentNo = input.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String postalCode = postCodeCheck(input.nextLine());
        return new User(firstName, lastName, login, email, password,
                new Address(street, buildingNo, apartmentNo, postalCode),
                List.of(Role.USER)
        );
    }


    public String loginCheck(String login) {
        if (!userValidator.validateUserLogin(login)) {
            System.out.println("Podany login już istnieje\nPodaj inny login");
            return loginCheck(input.nextLine());
        }
        return login;
    }

    public String emailCheck(String email) {
        if (!userValidator.validateUserEmail(email)) {
            System.out.println("Podany email jest niepoprawny\nPodaj inny email");
            return emailCheck(input.nextLine());
        }
        return email;
    }

    public String postCodeCheck(String postCode) {
        if (!userValidator.validateUserPostCode(postCode)) {
            System.out.println("Podany kod pocztowy jest niepoprawny\nPodaj poprawny kod");
            return postCodeCheck(input.nextLine());
        }
        return postCode;
    }
}
