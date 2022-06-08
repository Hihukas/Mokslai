package lt.codeacademy.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.Data.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String country;
    private Gender gender;
}
