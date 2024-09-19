package com.library.student_library_management_system.controller;

import com.library.student_library_management_system.dto.AuthorRequestDto;
import com.library.student_library_management_system.dto.StudentRequestDto;
import com.library.student_library_management_system.model.Author;
import com.library.student_library_management_system.service.AuthorService;
import com.library.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.createAuthor(authorRequestDto);
    }

    @GetMapping("/findAll")
    public List<Author> getAllAuthors(){

        return authorService.getAllAuthors();
    }

    @GetMapping("/find/{authorId}")
    public Author getAuthorById(@PathVariable("authorId") int authorId){
        return authorService.getAuthorById(authorId);
    }

    @PutMapping("/update/{authorid}")
    public String updateAuthor(@RequestBody AuthorRequestDto authorRequestDto,@PathVariable("authorid") int authorId){
        return authorService.updateAuthor(authorRequestDto, authorId);
    }
}
