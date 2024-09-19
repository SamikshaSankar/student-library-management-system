package com.library.student_library_management_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //its refer as a model or entity class
@Data //it adds getter and setters constructors
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="student")
public class Student {
    @Id //it refers as primary key and it cannot be duplicate
    @Column(name="id") //it creates column in table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="email", unique = true, nullable = false)//unique bcz no 2 student have same email
    private String email;
    @Column(name="mobile", nullable = false)
    private String mobile;
    @Column(name="age",nullable = false)
    private int age;
    @Column(name="grade", nullable = false)
    private String grade;

    @JsonManagedReference
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;
}
