package com.sda.provider;

import com.sda.model.Author;
import com.sda.model.Book;

import java.util.List;

public interface BookProvider {
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(Author author);
}