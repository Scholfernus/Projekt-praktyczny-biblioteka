package com.sda.service;

import com.sda.api.MainMenuOption;
import com.sda.view.ActiveUserUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainMenuService {
    public List<MainMenuOption> getOptionsAvailableForUser() {
        return Arrays.stream(MainMenuOption.values())
                .filter(mainMenuOption ->
                        ActiveUserUtil.getActiveUser().getRoles().contains(mainMenuOption.getNecessaryRole()))
                .collect(Collectors.toList());
    }
}
