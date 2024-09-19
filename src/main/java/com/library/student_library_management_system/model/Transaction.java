package com.library.student_library_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.library.student_library_management_system.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity //its refer as a model or entity class
@Data //it adds getter and setters constructors
@NoArgsConstructor
@AllArgsConstructor
@Table(name="transaction")
@Builder
public class Transaction {
    @Id //it refers as primary key and it cannot be duplicate
    @Column(name="id") //it creates column in table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="transactionStatus",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name="transaction_id",nullable = false)
    private String transactionid= UUID.randomUUID().toString();
    @Column(name="fine",nullable = false)
    private double fine;
    @Column(name="transactionDate",nullable = false)
    @CreationTimestamp
    private Date transactionDate;
    @Column(name="is_Issue_Operation",nullable = false)
    private boolean isIssueOperation;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;
}
