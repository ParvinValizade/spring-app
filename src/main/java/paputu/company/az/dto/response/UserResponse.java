package paputu.company.az.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;

}
