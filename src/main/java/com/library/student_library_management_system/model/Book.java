package com.library.student_library_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.library.student_library_management_system.enums.Genre;
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
@Table(name="book")
@Builder
public class Book {
    @Id //it refers as primary key and it cannot be duplicate
    @Column(name="id") //it creates column in table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="pages", nullable = false)//unique bcz no 2 student have same email
    private int pages;
    @Column(name="genre", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Genre genre;//horror. comedy,mythology, friction non friction
    //Genre created
    @Column(name="issuedToStudent",nullable = false)
    private boolean issuedToStudent;

    @JsonBackReference
    @ManyToOne
    @JoinColumn//in foreign key table we add join column
    private Card card;//this is used in parent Student model class while doing bidirectional mapping

    @JsonManagedReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transaction> transactionsList = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Author author;


}
