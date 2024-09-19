package com.library.student_library_management_system.converters;

import com.library.student_library_management_system.dto.AuthorRequestDto;
import com.library.student_library_management_system.model.Author;

public class AuthorConverters {
    public static Author convertAuthorRequestDtoToAuthor(AuthorRequestDto authorRequestDto){
        Author author =Author.builder().name(authorRequestDto.getName()).age(authorRequestDto.getAge())
                .country(authorRequestDto.getCountry()).rating(authorRequestDto.getRating()).build();
        return author;
    }
}
