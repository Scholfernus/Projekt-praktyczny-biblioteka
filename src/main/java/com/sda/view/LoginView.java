package com.sda.view;

import com.sda.api.UserLoginData;
import com.sda.controller.LoginController;
import com.sda.controller.LoginControllerImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class LoginView implements View {

    private Scanner scanner;
    private LoginController loginController;
    private Optional<String> message;

    public LoginView() {
        this.scanner = new Scanner(System.in);
        this.loginController = new LoginControllerImpl();
        this.message = Optional.empty();
    }

    public LoginView(Optional<String> message) {
        this.scanner = new Scanner(System.in);
        this.loginController = new LoginControllerImpl();
        this.message = message;
    }

    public LoginView(File inputFile) throws FileNotFoundException {
        this.scanner = new Scanner(inputFile);
        this.message = Optional.empty();
    }

    @Override
    public void display() {
        loginController.login(getData()).display();
    }

    UserLoginData getData() {
        message.ifPresent(System.out::println);
        System.out.println("Podaj Login");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło");
        String password = scanner.nextLine();
        return new UserLoginData(login, password);
    }
}