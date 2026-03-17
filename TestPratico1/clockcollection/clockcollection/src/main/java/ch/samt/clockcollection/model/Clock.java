package ch.samt.clockcollection.model;


import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Clock {
    @NotNull(message = "Error, value is null")
    @Positive(message = "Error, value has to be bigger than 0")
    private int id;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 2, max = 60, message = "Error, value has to be in between 2 and 50 characters")
    private String brand;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 2, max = 60, message = "Error, value has to be in between 2 and 50 characters")
    private String model;
    @NotNull(message = "Error, value is null")
    @Positive(message = "Error, value has to be bigger than 0")
    private double price;
}
