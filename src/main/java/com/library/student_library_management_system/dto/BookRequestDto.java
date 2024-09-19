package com.library.student_library_management_system.dto;

import com.library.student_library_management_system.enums.Genre;
import com.library.student_library_management_system.model.Card;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class BookRequestDto {
    private String name;

    private int pages;

    private Genre genre;
    private boolean issuedToStudent;
    private int cardId;
    private int authorId;

}
