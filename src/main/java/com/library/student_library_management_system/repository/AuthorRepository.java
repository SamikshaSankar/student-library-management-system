package com.library.student_library_management_system.repository;

import com.library.student_library_management_system.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //it does database operation
public interface AuthorRepository extends JpaRepository<Author, Integer>{
}
