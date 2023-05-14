package com.sda.provider;

import com.sda.model.Author;
import com.sda.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.List;


class FileBookProviderTest {

    private static final Book BOOK1 = Book.builder()
            .title("The Great Gatsby")
            .isbn("9780743273565")
            .author(new Author("F. Scott", "Fitzgerald"))
            .releasedYear(Year.parse("1925"))
            .build();

    private static final Book BOOK2 = Book.builder()
            .title("To Kill a Mockingbird")
            .isbn("9780060935467")
            .author(new Author("Harper", "Lee"))
            .releasedYear(Year.parse("1960"))
            .build();

    private static final Book BOOK3 = Book.builder()
            .title("The Great Gatsby2")
            .isbn("9780743243465")
            .author(new Author("F. Scott", "Fitzgerald"))
            .releasedYear(Year.parse("1935"))
            .build();


    private static final List<Book> EXPECTED_BOOKS = List.of(BOOK1, BOOK2, BOOK3);

    @Test
    void shouldProvideAndMapAllBooksFromFile() {
        //given
        BookProvider bookProvider = new FileBookProvider("src/test/resources/test_books");
        //when
        List<Book> result = bookProvider.getAllBooks();
        //then
        Assertions.assertThat(result).containsAll(EXPECTED_BOOKS);
    }

    @Test
    void shouldIgnoreEmptyLines() {
        //given
        BookProvider bookProvider = new FileBookProvider("src/test/resources/test_books_emptylines");
        //when
        List<Book> result = bookProvider.getAllBooks();
        //then
        Assertions.assertThat(result).containsAll(EXPECTED_BOOKS);
    }

    @Test
    void shouldProvideAndMapBooksByAuthorFromFile() {
        //given
        BookProvider bookProvider = new FileBookProvider("src/test/resources/test_books");
        List<Book> expectedBooksByAuthor = List.of(BOOK1, BOOK3);
        //when
        List<Book> result = bookProvider.getBooksByAuthor(new Author("F. Scott", "Fitzgerald"));
        //then
        Assertions.assertThat(result).containsAll(expectedBooksByAuthor);
    }


}