package lt.codeacademy.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "users")
public class User {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY);

    @Id
    private Long id;
    private String name;
    private String surname;
//    @Column(name = "e-mail", nullable = false)
    private String email;
}
