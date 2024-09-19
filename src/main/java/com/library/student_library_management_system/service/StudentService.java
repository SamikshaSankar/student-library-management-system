package com.library.student_library_management_system.service;

import com.library.student_library_management_system.dto.StudentRequestDto;
import com.library.student_library_management_system.enums.CardStatus;
import com.library.student_library_management_system.model.Card;
import com.library.student_library_management_system.model.Student;
import com.library.student_library_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.library.student_library_management_system.converters.StudentConverter.convertStudentRequestDtoToStudent;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
       //creates model class object
       Student student = new Student();

       //take requestdto input and set it inside student object

//        student.setName(studentRequestDto.getName());
//        student.setEmail(studentRequestDto.getEmail());
//        student.setAge(studentRequestDto.getAge());
//        student.setMobile(studentRequestDto.getMobile());
//        student.setGrade(studentRequestDto.getGrade());

        student = convertStudentRequestDtoToStudent(studentRequestDto);

        //whenever a student created a card for the student is also created
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        student.setCard(card);

        //save the student object
        studentRepository.save(student);//when saving student in student repository even card gets saved in cardRepository through cascading effect

        return "Student added";
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student getStudentById(int studentId){
       Optional<Student> studentOptional= studentRepository.findById(studentId);
        Student student = studentOptional.get();
        return student;
    }

    public String updateStudent(StudentRequestDto studentRequestDto, int studentId){
        //whenever we perform update operation first we have to find operation and after that update
        Student studentFromDb = studentRepository.findById(studentId).get();

        if(studentFromDb!=null) {
            studentFromDb.setName(studentRequestDto.getName());
            studentFromDb.setAge(studentRequestDto.getAge());
            studentFromDb.setMobile(studentRequestDto.getMobile());
            studentFromDb.setEmail(studentRequestDto.getEmail());
            studentFromDb.setGrade(studentRequestDto.getGrade());
            studentRepository.save(studentFromDb);
            return "Student Updated successfully";
        }
        return "Student not exist so update operation cannot be performed";
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);
        return "Student deleted";
    }

    public Student getStudentByEmail(String email){
        Student student =  studentRepository.findByEmail(email);
        return student;
    }

    public List<Student> getStudentByGrade(String grade){
        List<Student> studentList =  studentRepository.findByGrade(grade);
        return studentList;
    }
    //pagination - fetching records/data in the form of pages
    //pagenumber- the number of page we want to see(page number starts from zero)
    //pagesize- the total number of records in each page(find in each)
    //database total records =27, page size-5
    //oth page= 1-5
    //1st page=6-10
    //2nd page =11-15
    //3th page= 16-20
    //4th page =21-25
    //5th page = 26-28



}
