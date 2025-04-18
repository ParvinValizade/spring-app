package paputu.company.az;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class PaputuApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaputuApplication.class, args);
	}

}
