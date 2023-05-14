package com.sda;

import com.sda.provider.FileUserProvider;
import com.sda.provider.UserProvider;
import com.sda.view.BooksByAuthorView;
import com.sda.view.LoginView;
import com.sda.view.View;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserProvider userProvider = new FileUserProvider();
        System.out.println(userProvider.getAllUser());
        View view = new LoginView();
        view.display();
        View booksView = new BooksByAuthorView();
        booksView.display();

        view.display();
    }

}