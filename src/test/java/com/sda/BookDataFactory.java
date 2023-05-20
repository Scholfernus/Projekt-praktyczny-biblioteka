package com.sda;

import com.sda.model.Author;
import com.sda.model.Book;

import java.time.Year;
import java.util.List;

public class BookDataFactory {
    public static final Book BOOK1 = Book.builder()
            .title("The Great Gatsby")
            .isbn("9780743273565")
            .author(new Author("F. Scott", "Fitzgerald"))
            .releasedYear(Year.parse("1925"))
            .build();

    public static final Book BOOK2 = Book.builder()
            .title("To Kill a Mockingbird")
            .isbn("9780060935467")
            .author(new Author("Harper", "Lee"))
            .releasedYear(Year.parse("1960"))
            .build();

    public static final Book BOOK3 = Book.builder()
            .title("The Great Gatsby2")
            .isbn("9780743243465")
            .author(new Author("F. Scott", "Fitzgerald"))
            .releasedYear(Year.parse("1935"))
            .build();



    private static final List<Book> EXPECTED_BOOKS = List.of(BOOK1, BOOK2, BOOK3);

    public static List<Book> getExampleBooksData() {
        return EXPECTED_BOOKS;
    }

    public static List<Book> getExapleBooksByAuthor() {

        return List.of(BOOK1, BOOK3);
    }

}