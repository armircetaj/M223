package ch.samt.esercizio2.model;


import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    @NotNull(message = "Errore, campo nullo")
    private int id;
    @NotBlank(message = "Errore, campo nullo")
    @Size(min = 2, max = 50, message = "Deve essere almeno di 2 caratteri e massimo 50")
    private String name;
    @NotNull(message = "Errore, campo nullo")
    @Positive(message = "Il prezzo deve essere positivo")
    private double price;
    @NotNull(message = "Errore, campo nullo")
    @FutureOrPresent(message = "La data deve essere futura")
    private LocalDate expirationDate;
    @NotNull
    @Size(min = 10, max = 1000, message = "Deve contenere una descrizione")
    private String description;
}
