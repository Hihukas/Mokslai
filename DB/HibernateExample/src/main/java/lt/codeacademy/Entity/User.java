package lt.codeacademy.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String name;
    private String surname;
    @Column(name = "e-mail")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) unidirection relation
//    @JoinColumn(name = "addresses_id")

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //bidirection relation
    private Set<Address> addresses;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "our_table",
//            joinColumns = {
//                    @JoinColumn(name="user_id", referencedColumnName = "id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name="company_id", referencedColumnName = "id")
//            }
//    )
    private Set<Company> companies;

}
