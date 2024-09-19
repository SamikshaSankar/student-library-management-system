package com.library.student_library_management_system.controller;

import com.library.student_library_management_system.dto.StudentRequestDto;
import com.library.student_library_management_system.model.Author;
import com.library.student_library_management_system.model.Student;
import com.library.student_library_management_system.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    //declaring loggers
    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/find/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId){
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/update/{studentid}")
    public String updateStudent(@RequestBody StudentRequestDto studentRequestDto,@PathVariable("studentid") int studentId){
      return studentService.updateStudent(studentRequestDto,studentId);
    }

    @DeleteMapping("/delete/{student}")
    public String deleteStudentById(@PathVariable("student")int studentId){
        return studentService.deleteStudentById(studentId);
    }

    @GetMapping("/findByEmail")
    public Student getStudentByEmail(@RequestParam("email") String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/findByGrade")
    public List<Student> getStudentByGrade(@RequestParam("grade") String grade){
        return studentService.getStudentByGrade(grade);
    }
}
