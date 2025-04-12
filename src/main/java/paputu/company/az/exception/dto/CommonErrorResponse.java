package paputu.company.az.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonErrorResponse {

    private String requestId;
    private String errorCode;
    private String message;

}
