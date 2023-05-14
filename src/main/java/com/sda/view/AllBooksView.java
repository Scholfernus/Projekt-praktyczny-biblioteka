package com.sda.view;

import java.util.Scanner;


public class AllBooksView extends BooksView implements View {
    private Scanner scanner;

    @Override
    public void display() {
        display(getBookController().getAllBooks());
    }
}