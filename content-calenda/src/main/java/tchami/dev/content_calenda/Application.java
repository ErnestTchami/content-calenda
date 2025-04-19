package tchami.dev.content_calenda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tchami.dev.content_calenda.model.Content;
import tchami.dev.content_calenda.model.Status;
import tchami.dev.content_calenda.model.Type;
import tchami.dev.content_calenda.repository.ContentRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository) {
		return args -> {
//			Insert the dummy data to start with
			Content content = new Content(null,
					"tchami test data for commandline runner 😆😆",
					"this is the best description for testing data ",
					Status.IDEA,
					Type.ARTICLE,
					LocalDateTime.now(),
					null,
					""
			);
			contentRepository.save(content);
		};
	}

}
