package com.sda;

import com.sda.view.BooksByAuthorView;
import com.sda.view.LoginView;
import com.sda.view.View;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        View booksView = new BooksByAuthorView();
        booksView.display();
        View view = new LoginView();
        view.display();
    }
}
