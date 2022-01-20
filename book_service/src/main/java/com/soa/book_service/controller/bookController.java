package com.soa.book_service.controller;

import com.soa.book_service.model.Book;
import com.soa.book_service.service.bookService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class bookController {
    private final bookService bookService;

    public bookController(bookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        Book book = bookService.getBook(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }



    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book rbook = bookService.addBook(book);
        return new ResponseEntity<>(rbook, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book ubook = bookService.updateBook(book);
        return new ResponseEntity<>(ubook, HttpStatus.OK);
    }
}
