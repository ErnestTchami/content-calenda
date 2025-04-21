package tchami.dev.content_calenda.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tchami.dev.content_calenda.model.Content;
import tchami.dev.content_calenda.repository.ContentRepository;

import java.io.InputStream;
import java.util.List;


//this profile control which environment  this can be used on
//@Profile("!dev")
@Component
public class DataLoader  implements CommandLineRunner {
    private final ObjectMapper objectMapper;
    private final ContentRepository repository;

    public DataLoader(ObjectMapper objectMapper,ContentRepository contentRepository){
        this.objectMapper=objectMapper;
        this.repository =contentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       try(InputStream inputStream= TypeReference.class.getResourceAsStream("/data/content.json")) {
           repository.saveAll(objectMapper.readValue(inputStream ,new TypeReference<List<Content>>(){}));
       }
    }
}
