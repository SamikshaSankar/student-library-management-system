package com.library.student_library_management_system.dto;

import com.library.student_library_management_system.enums.TransactionStatus;
import com.library.student_library_management_system.model.Book;
import com.library.student_library_management_system.model.Card;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
public class TransactionDto {
    private TransactionStatus transactionStatus;
    private double fine;
    private boolean issueOperation;

    private int bookId;

    private int cardId;
}
