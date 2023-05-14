package com.sda.controller;

import com.sda.model.Author;
import com.sda.model.Book;
import com.sda.provider.FileBookProvider;
import com.sda.service.DisplayUtil;

import java.util.Map;

public class BookControllerImpl implements BookController {
    private FileBookProvider fileBookProvider;
    private DisplayUtil<Book> bookDisplayUtil = new DisplayUtil<>();

    public BookControllerImpl() {
        this.fileBookProvider = new FileBookProvider();
    }
    @Override
    public Map<Integer, Book> getAllBooks() {
        return bookDisplayUtil.getItems(fileBookProvider.getAllBooks());
    }
    @Override
    public Map<Integer, Book> getBooksByAuthor(Author author) {
        return bookDisplayUtil.getItems(fileBookProvider.getBooksByAuthor(author));
    }
}