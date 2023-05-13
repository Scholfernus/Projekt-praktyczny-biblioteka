package com.sda;

import com.sda.provider.FileUserProvider;
import com.sda.provider.UserProvider;
import com.sda.view.LoginView;
import com.sda.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new LoginView();
        view.display();
    }

}