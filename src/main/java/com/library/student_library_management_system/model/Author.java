package com.library.student_library_management_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity //its refer as a model or entity class
@Data //it adds getter and setters constructors
@NoArgsConstructor
@AllArgsConstructor
@Table(name="author")
@Builder
public class Author {
    @Id //it refers as primary key and it cannot be duplicate
    @Column(name="id") //it creates column in table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name= "name" , nullable = false)
    private String name;
    @Column (name= "age" , nullable = false)
    private int age;
    @Column (name= "country" , nullable = false)
    private String country;
    @Column (name= "rating" , nullable = false)
    private double rating;

    @JsonManagedReference
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> booksOfAuthor = new ArrayList<>();
}
