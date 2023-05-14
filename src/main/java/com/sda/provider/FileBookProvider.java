package com.sda.provider;

import com.sda.model.*;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class FileBookProvider implements BookProvider{

    private String filePath = "src/main/resources/books";

    public FileBookProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = List.of();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            books = bufferedReader.lines()
                    .filter(line -> !line.isBlank())
                    .map(this::mapToBook)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getBooksByAuthor(Author author){
        return getAllBooks().stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    private Book mapToBook(String userDataLine) {
        String[] splitBookData = userDataLine.split(";");
        return Book.builder()
                .title(splitBookData[0])
                .isbn(splitBookData[1])
                .author(mapToAuthor(splitBookData))
                .releasedYear(Year.parse(splitBookData[4]))
                .build();
    }

    private Author mapToAuthor(String[] splitUserData) {
        return Author.builder()
                .firstName(splitUserData[2])
                .lastName(splitUserData[3])
                .build();
    }
}