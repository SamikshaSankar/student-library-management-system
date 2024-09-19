package com.library.student_library_management_system.controller;

import com.library.student_library_management_system.dto.AuthorRequestDto;
import com.library.student_library_management_system.dto.BookRequestDto;
import com.library.student_library_management_system.model.Author;
import com.library.student_library_management_system.model.Book;
import com.library.student_library_management_system.service.AuthorService;
import com.library.student_library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.createBook(bookRequestDto);
    }

    @GetMapping("/findAll")
    public List<Book> getAllBooks(){

        return bookService.getAllBooks();
    }

    @GetMapping("/find/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }
}
