package com.library.student_library_management_system.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentRequestDto {
    //here we can take input parameters which are going inside request
    private String name;
    private String email;
    private String mobile;
    private int age;
    private String grade;
}
