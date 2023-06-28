package com.example.minor1.dtos;

import com.example.minor1.models.Author;
import com.example.minor1.models.Book;
import com.example.minor1.models.Genre;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest {

    @NotBlank
    private String name;

    @NotNull
    private Genre genre;

    @NotBlank
    private String authorName;

    @NotBlank
    private String authorEmail;

    public Book to() {

        Author author = Author.builder()
                .name(this.authorName)
                .email(this.authorEmail)
                .build();

        return Book.builder()
                .name(this.name)
                .genre(this.genre)
                .my_author(author)
                .build();
    }
}
