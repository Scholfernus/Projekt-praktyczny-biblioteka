package com.sda.controller;

import com.sda.BookDataFactory;
import com.sda.model.Author;
import com.sda.model.Book;
import com.sda.provider.BookProvider;
import com.sda.view.View;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sda.BookDataFactory.BOOK1;
import static com.sda.BookDataFactory.BOOK3;
import static org.junit.jupiter.api.Assertions.*;

class BookControllerImplTest {

    BookController bookController = new BookControllerImpl(new BookProvider() {
        @Override
        public List<Book> getAllBooks() {
            return BookDataFactory.getExampleBooksData();
        }

        @Override
        public List<Book> getBooksByAuthor(Author author) {
            return getAllBooks().stream()
                    .filter(book -> book.getAuthor().equals(author))
                    .collect(Collectors.toList());
        }
    });
    @Test
    void shouldReturnMapOfBooksByAuthor() {
        //given
        Map<Integer, Book> expectedBooks = Map.of(1, BOOK1, 2, BOOK3);
        //when
        Map<Integer, Book> result = bookController.getBooksByAuthor(new Author("F. Scott", "Fitzgerald"));
        //then
        Assertions.assertThat(result).isEqualTo(expectedBooks);
    }
}