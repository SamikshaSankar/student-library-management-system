package com.library.student_library_management_system.repository;

import com.library.student_library_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //writing our own method for performing database queries using field or attributes

    public Student findByEmail(String email); //internally JPA calls this methods and adds query
    //select * from student where email ="sumita@gmail.com"
    //return single student

    public List<Student> findByGrade(String grade);
    //select * from student where grade "10th grade
    //return list of student
}
