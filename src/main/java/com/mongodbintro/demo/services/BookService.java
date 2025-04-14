package com.mongodbintro.demo.services;

import com.mongodbintro.demo.modell.dto.BookDTO;

import java.util.List;

public interface BookService {

    public  BookDTO getBook(String bookId);
    public List<BookDTO> getAllBooks();
    public BookDTO createBook(BookDTO bookDTO);
    public BookDTO updateBookName(String bookId, BookDTO bookDTO);
    public void deleteBookByBookId(String bookId);
}
