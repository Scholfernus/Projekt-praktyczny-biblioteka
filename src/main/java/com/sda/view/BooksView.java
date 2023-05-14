package com.sda.view;

import com.sda.controller.BookController;
import com.sda.controller.BookControllerImpl;
import com.sda.model.Book;

import java.util.Map;

abstract class BooksView {
    private BookController bookController;

    public BooksView() {
        this.bookController = new BookControllerImpl();
    }

    BookController getBookController() {
        return bookController;
    }

    public void display(Map<Integer, Book> books){
        System.out.println("no, title, isbn, author, release date");
        books.forEach((integer, book) -> System.out.println(integer + ". " + book));
    }
}