package ch.samt.customers.model;


import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Customers {
    @NotNull(message = "Error, value is null")
    @Positive(message = "Error, value has to be bigger than 0")
    private Long id;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 2, max = 50, message = "Error, value has to be in between 2 and 50 characters")
    private String name;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 2, max = 50, message = "Error, value has to be in between 2 and 50 characters")
    private String surname;
    @NotNull(message = "Error, value is null")
    @Positive(message = "Error, value has to be bigger than 0")
    private Integer age;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 3, max = 20, message = "Error, value has to be in between 3 and 20 characters")
    private String city;
    @CreditCardNumber
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])\\/\\d{2}$",
            message = "Error, format has to be MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0)
    private String ccCVV;
}
