package com.sda.api;

import com.sda.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MainMenuOption {
    CREATE_USER("Dodaj nowego użytkownika", Role.ADMIN),
    DISPLAY_BOOKS("Wyświetl dostępne książki", Role.USER);
    private final String text;
    private final Role necessaryRole;
}
