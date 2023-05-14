package com.sda.controller;

import com.sda.model.Author;
import com.sda.model.Book;

import java.util.Map;

public interface BookController {
    Map<Integer, Book> getAllBooks();
    Map<Integer, Book> getBooksByAuthor(Author author);
}