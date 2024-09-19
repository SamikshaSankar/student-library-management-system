package com.library.student_library_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.library.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity //its refer as a model or entity class
@Data //it adds getter and setters constructors
@NoArgsConstructor
@AllArgsConstructor
@Table(name="card")
public class Card {
    @Id //it refers as primary key and it cannot be duplicate
    @Column(name="id") //it creates column in table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="created_On",nullable = false)
    @CreationTimestamp//auto time is set when the entry/card is created
    private Date createdOn;

    @Column(name="updated_On",nullable = false)
    @UpdateTimestamp//updates time when the entry/card is updated
    private Date updatedOn;

    @Column(name="card_status",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @JsonBackReference
    @OneToOne
    @JoinColumn//in foreign key table we add join column
    private Student student;//this is used in parent Student model class while doing bidirectional mapping

    @JsonManagedReference
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Book> bookIssued = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transaction> trasactionList = new ArrayList<>();
}
