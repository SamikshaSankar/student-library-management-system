package com.library.student_library_management_system.service;

import com.library.student_library_management_system.dto.TransactionDto;
import com.library.student_library_management_system.model.Book;
import com.library.student_library_management_system.model.Card;
import com.library.student_library_management_system.model.Student;
import com.library.student_library_management_system.model.Transaction;
import com.library.student_library_management_system.repository.BookRepository;
import com.library.student_library_management_system.repository.CardRepository;
import com.library.student_library_management_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.library.student_library_management_system.converters.TransactionConverter.convertTransactionRequestDtoToTransaction;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;
    public String createTransaction(TransactionDto transactionDto){
        Transaction transaction = new Transaction();
        transaction = convertTransactionRequestDtoToTransaction(transactionDto);

        //get card detais from cardId
         Card card = cardRepository.findById(transactionDto.getCardId()).get();
         transaction.setCard(card);

         Book book = bookRepository.findById(transactionDto.getBookId()).get();
         transaction.setBook(book);

         transactionRepository.save(transaction);

         return "Transaction created";
    }

    public List<Transaction> getAllTransaction(){
        List<Transaction> transactionList = transactionRepository.findAll();
        return transactionList;
    }

    public Transaction getTransactionById(int transactionId){
        Optional<Transaction> transactionOptional= transactionRepository.findById(transactionId);
        Transaction transaction = transactionOptional.get();
        return transaction;
    }
}
