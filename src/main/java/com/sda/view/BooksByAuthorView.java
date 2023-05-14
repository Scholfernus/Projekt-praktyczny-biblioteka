package com.sda.view;

import com.sda.model.Author;

import java.util.Scanner;

public class BooksByAuthorView extends BooksView implements View{

    private Scanner scanner;

    public BooksByAuthorView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void display() {
        display(getBookController().getBooksByAuthor(getAuthor()));
    }

    private Author getAuthor(){
        System.out.println("Podaj imię autora: ");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko autora: ");
        String lastName = scanner.nextLine();
        return new Author(firstName,lastName);
    }
}