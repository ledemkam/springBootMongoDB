package com.mongodbintro.demo.controllers;


import com.mongodbintro.demo.modell.dto.BookDTO;
import com.mongodbintro.demo.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/book-store")
public class BookController {

    private final BookService bookService;

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<BookDTO> getBooks(@PathVariable String bookId) {
        BookDTO bookDTO = bookService.getBook(bookId);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO book = bookService.createBook(bookDTO);
        return new ResponseEntity<>(bookDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable String bookId, @RequestBody BookDTO bookDTO) {
        BookDTO book = bookService.updateBookName(bookId, bookDTO);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable  String bookId) {
        bookService.deleteBookByBookId(bookId);
        return new ResponseEntity<>( bookId, HttpStatus.OK);
    }
}
