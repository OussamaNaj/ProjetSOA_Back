package com.soa.book_service.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.soa.book_service.model.Book;
import com.soa.book_service.repository.bookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class bookService {
    private final bookRepository bookRepository;

    @Autowired
    public bookService(bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        try {
            if (bookRepository.findById(book.getId()).isPresent())
                throw new Exception("book already exists");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        try {
            if (!bookRepository.findById(id).isPresent())
                throw new Exception("book doesn't exist");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        bookRepository.deleteById(id);
    }

    public Book getBook(Long id) {
        try {
            if (!bookRepository.findById(id).isPresent())
                throw new Exception("book doesn't exist");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return bookRepository.getById(id);
    }

    public ArrayList<Book> getAllBooks() {
        return (ArrayList<Book>) bookRepository.findAll();
    }
}
