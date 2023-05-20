package com.sda.view;


import com.sda.api.MainMenuOption;
import com.sda.controller.MainMenuController;

import java.util.Map;
import java.util.Scanner;


public class MainMenuView implements View {
    private MainMenuController mainMenuController;
    private Scanner scanner;

    public MainMenuView() {
        this.mainMenuController = new MainMenuController();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void display() {
        Map<Integer, MainMenuOption> availableOptions = mainMenuController.getAvailableOptions();
        availableOptions.forEach((integer, mainMenuOption) ->
                System.out.println(integer + ". " + mainMenuOption.getText()));
        mainMenuController.getSelectedOption(availableOptions.get(scanner.nextInt())).display();
    }
}
