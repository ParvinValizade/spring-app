package paputu.company.az.dto.request;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
