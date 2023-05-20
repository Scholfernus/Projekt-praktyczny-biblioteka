package com.sda.controller;

import com.sda.api.MainMenuOption;
import com.sda.service.DisplayUtil;
import com.sda.service.MainMenuService;
import com.sda.view.AllBooksView;
import com.sda.view.MainMenuView;
import com.sda.view.NewUserView;
import com.sda.view.View;

import java.util.List;
import java.util.Map;

public class MainMenuController {
    private MainMenuService mainMenuService;

    public MainMenuController() {
        this.mainMenuService = new MainMenuService();
    }

    public Map<Integer, MainMenuOption> getAvailableOptions() {
        DisplayUtil<MainMenuOption> displayUtil = new DisplayUtil<>();
        return displayUtil.getItems(mainMenuService.getOptionsAvailableForUser());
    }

    public View getSelectedOption(MainMenuOption menuOption) {
        switch (menuOption) {
            case CREATE_USER:
                return new NewUserView();

            case DISPLAY_BOOKS:
                return new AllBooksView();

            default:
                new MainMenuView();
        }
        return new MainMenuView();
    }
}
