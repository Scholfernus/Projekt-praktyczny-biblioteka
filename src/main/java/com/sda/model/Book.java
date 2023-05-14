package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String title;
    private String isbn;
    private Author author;
    private Year releasedYear;

    @Override
    public String toString() {

        return  title + ", " + isbn + ", " + author + ", " + releasedYear;
    }
}