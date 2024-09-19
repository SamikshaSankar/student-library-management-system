package com.library.student_library_management_system.converters;

import com.library.student_library_management_system.dto.TransactionDto;
import com.library.student_library_management_system.model.Transaction;

import java.util.UUID;

public class TransactionConverter {
 public  static Transaction convertTransactionRequestDtoToTransaction(TransactionDto transactionDto){
     Transaction transaction = Transaction.builder().transactionStatus(transactionDto.getTransactionStatus()).fine(transactionDto.getFine())
             .transactionid(UUID.randomUUID().toString()).isIssueOperation(transactionDto.isIssueOperation()).build();
     return transaction;
 }
}
