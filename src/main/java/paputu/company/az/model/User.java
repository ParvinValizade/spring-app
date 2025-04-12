package paputu.company.az.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@ToString(exclude = {"password"})
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String firstName;

    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column
    private String password;

}
