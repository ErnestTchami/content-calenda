package tchami.dev.content_calenda.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

// this is the first way to implement this
//@Controller
public class DataLoader  implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Data Loading 👋🏻");
    }
}
