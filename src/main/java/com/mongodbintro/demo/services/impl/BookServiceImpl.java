package com.mongodbintro.demo.services.impl;

import com.mongodbintro.demo.mapper.BookMapper;
import com.mongodbintro.demo.modell.dto.BookDTO;
import com.mongodbintro.demo.modell.entity.Book;
import com.mongodbintro.demo.repository.BookRepository;
import com.mongodbintro.demo.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Override
    public BookDTO getBook(String bookId) {
        Book book = bookRepository.findBookByBookId(bookId);
        return BookMapper.toDTO(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDTO = BookMapper.toDTO(book);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookRepository.insert(BookMapper.toEntity(bookDTO));
        return BookMapper.toDTO(book);
    }

    @Override
    public BookDTO updateBookName(String bookId, BookDTO bookDTO) {
        bookRepository.updateBookNameByBookId(bookDTO.bookId(), bookDTO.name());
        Book book = bookRepository.findBookByBookId(bookDTO.bookId());
        return BookMapper.toDTO(book);
    }

    @Override
    public void deleteBookByBookId(String bookId) {
        bookRepository.deleteBookByBookId(bookId);

    }
}
