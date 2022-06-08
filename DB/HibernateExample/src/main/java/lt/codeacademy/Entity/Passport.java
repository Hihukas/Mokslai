package lt.codeacademy.Entity;

import jakarta.persistence.*;
import lombok.*;
import lt.codeacademy.Data.Gender;

@Setter
@Getter
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

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private User user;

    public Passport(Long id, String code, String country, Gender gender) {
        this.id = id;
        this.code = code;
        this.country = country;
        this.gender = gender;
    }
}
