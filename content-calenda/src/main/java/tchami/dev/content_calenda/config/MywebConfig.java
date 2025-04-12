package tchami.dev.content_calenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MywebConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
