package com.sda.controller;

import com.sda.model.Book;
import com.sda.provider.FileBookProvider;

import java.util.List;

public class BookControllerImpl implements BookController {
 // Klasa zawiera metody do zamiany na mapy
    private FileBookProvider fileBookProvider;

    public BookControllerImpl() {
        this.fileBookProvider = new FileBookProvider();
    }

    @Override
    public List<Book> getAllBooks() {
        return fileBookProvider.getAllBooks();
    }
}
//