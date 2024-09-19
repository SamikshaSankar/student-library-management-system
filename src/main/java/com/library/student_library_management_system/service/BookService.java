package com.library.student_library_management_system.service;

import com.library.student_library_management_system.dto.BookRequestDto;
import com.library.student_library_management_system.model.Author;
import com.library.student_library_management_system.model.Book;
import com.library.student_library_management_system.model.Card;
import com.library.student_library_management_system.model.Student;
import com.library.student_library_management_system.repository.AuthorRepository;
import com.library.student_library_management_system.repository.BookRepository;
import com.library.student_library_management_system.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.library.student_library_management_system.converters.BookConverter.convertBookRequestDtoToBook;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AuthorRepository authorRepository;
    public String createBook(BookRequestDto bookRequestDto){
        Book book = new Book();
        book = convertBookRequestDtoToBook(bookRequestDto);

        //first get the car detais from cardId
        Card card = cardRepository.findById(bookRequestDto.getCardId()).get();

        book.setCard(card);

        //next we need to get author detais from authorId
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);
        bookRepository.save(book);
        return "Book saved successfully";
    }

    public List<Book> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public Book getBookById(int bookId){
        Optional<Book> bookOptional= bookRepository.findById(bookId);
        Book book = bookOptional.get();
        return book;
    }
}
