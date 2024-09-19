package com.library.student_library_management_system.controller;

import com.library.student_library_management_system.dto.StudentRequestDto;
import com.library.student_library_management_system.dto.TransactionDto;
import com.library.student_library_management_system.model.Author;
import com.library.student_library_management_system.model.Transaction;
import com.library.student_library_management_system.service.StudentService;
import com.library.student_library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController{
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public String addTransaction(@RequestBody TransactionDto transactionDto){
        return transactionService.createTransaction(transactionDto);
    }

    @GetMapping("/findAll")
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransaction();
    }

    @GetMapping("/find/{transactionId}")
    public Transaction getTransactionById(@PathVariable("transactionId") int transactionId){
        return transactionService.getTransactionById(transactionId);
    }
}
