package com.sda.view;

import com.sda.api.UserLoginData;
import com.sda.controller.LoginController;
import com.sda.controller.LoginControllerImpl;

import java.util.Optional;
import java.util.Scanner;

public class LoginView implements View {
    private Scanner scanner;
    private LoginController loginController;
    private Optional<String> message;

    public LoginView(Optional<String> message) {
        this.message = message;
    }

    public LoginView() {
        this.scanner = new Scanner(System.in);
        this.loginController = new LoginControllerImpl();
        this.message = message;
    }

    @Override
    public void display() {
        loginController.login(getData());
    }

    UserLoginData getData() {
        message.ifPresent(System.out::println);
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło");
        String password = scanner.nextLine();
        return new UserLoginData(login, password);

    }
}
