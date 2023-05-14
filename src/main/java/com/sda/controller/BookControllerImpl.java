package com.sda.controller;

import com.sda.model.Author;
import com.sda.model.Book;
import com.sda.provider.BookProvider;
import com.sda.provider.FileBookProvider;
import com.sda.service.DisplayUtil;

import java.util.Map;

public class BookControllerImpl implements BookController {
    private BookProvider bookProvider;
    private DisplayUtil<Book> bookDisplayUtil = new DisplayUtil<>();

    public BookControllerImpl() {
        this.bookProvider = new FileBookProvider();
    }

    public BookControllerImpl(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    @Override
    public Map<Integer, Book> getAllBooks() {
        return bookDisplayUtil.getItems(bookProvider.getAllBooks());
    }
    @Override
    public Map<Integer, Book> getBooksByAuthor(Author author) {
        return bookDisplayUtil.getItems(bookProvider.getBooksByAuthor(author));
    }
}