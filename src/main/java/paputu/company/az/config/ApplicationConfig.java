package paputu.company.az.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApplicationConfig {

    @Value("${paputu.count}")
    private Integer count;

}
