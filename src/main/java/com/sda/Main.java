package com.sda;

import com.sda.dao.user.FileUserDao;
import com.sda.dao.user.UserProvider;
import com.sda.view.BooksByAuthorView;
import com.sda.view.LoginView;
import com.sda.view.NewUserView;
import com.sda.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new LoginView();
        view.display();
        View booksView = new BooksByAuthorView();
        booksView.display();

        view.display();
    }

}