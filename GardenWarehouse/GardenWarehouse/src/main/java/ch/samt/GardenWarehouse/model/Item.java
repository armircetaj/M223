package ch.samt.GardenWarehouse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.aspectj.bridge.IMessage;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warehouse_seq")
    @SequenceGenerator(name="warehouse_seq", sequenceName = "warehouse_seq", allocationSize = 1)
    private Long id;
    @Pattern(
            regexp = "^[a-z]{3}-\\d{2}$",
            message = "Error, format has to be abc-12")
    private String code;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 2, max = 50, message = "Error, value has to be in between 2 and 50 characters")
    private String type;
    @NotBlank(message = "Error, value is blank")
    @Size(min = 2, max = 50, message = "Error, value has to be in between 2 and 50 characters")
    private String name;
    @NotNull(message = "Error, value is null")
    @Positive(message = "Error, value has to be bigger than 0")
    private BigDecimal price;
    @NotNull(message = "Error, value is null")
    @Positive(message = "Error, value has to be bigger than 0")
    private int itemCount;
}
