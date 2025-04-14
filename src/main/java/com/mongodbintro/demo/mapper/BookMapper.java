package com.mongodbintro.demo.mapper;

import com.mongodbintro.demo.modell.dto.BookDTO;
import com.mongodbintro.demo.modell.entity.Book;

public class BookMapper {
    //le but de ce mapper est de convertir un objet Book en un objet BookDTO et vice versa/**


    // * Konvertiert ein Book-Entity-Objekt in ein BookDTO-Objekt

    public static BookDTO toDTO(Book book) {
       return new BookDTO(book.bookId(), book.name(), book.price(), book.autor(), book.description());
    }
    ///**
    // * Konvertiert ein BookDTO-Objekt in ein Book-Entity-Objekt
    public static Book toEntity(BookDTO bookDTO) {
       return new Book(bookDTO.bookId(), bookDTO.name(), bookDTO.price(), bookDTO.autor(), bookDTO.description());
    }
}
