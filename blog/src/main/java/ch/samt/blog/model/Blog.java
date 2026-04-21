package ch.samt.blog.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_seq")
    @SequenceGenerator(name = "blog_seq", sequenceName = "blog_seq", allocationSize = 1)
    private Long id;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 2, max = 50, message = "Error, value has to be in between 5 and 50 characters")
    private String title;
    @FutureOrPresent
    private Date date;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 2, max = 50, message = "Error, value has to be in between 5 and 50 characters")
    private String category;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 2, max = 50, message = "Error, value has to be in between 5 and 50 characters")
    private String author;
    @NotNull(message = "Error, value is null")
    @Positive(message = "Error, value has to be bigger than 0")
    private int likes;
    @Lob
    @NotBlank(message = "Error, value is blank")
    private String content;
}
