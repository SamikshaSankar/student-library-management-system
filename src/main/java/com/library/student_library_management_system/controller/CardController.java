package com.library.student_library_management_system.controller;

import com.library.student_library_management_system.dto.StudentRequestDto;
import com.library.student_library_management_system.model.Author;
import com.library.student_library_management_system.model.Card;
import com.library.student_library_management_system.model.Student;
import com.library.student_library_management_system.service.CardService;
import com.library.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/findAll")
    public List<Card> getAllCards(){
        return cardService.getAllCards();
    }

    @GetMapping("/find/{cardId}")
    public Card getCardById(@PathVariable("cardId") int cardId){
        return cardService.getCardById(cardId);
    }

}
