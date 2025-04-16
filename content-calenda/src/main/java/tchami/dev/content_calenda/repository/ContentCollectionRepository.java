package tchami.dev.content_calenda.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import tchami.dev.content_calenda.model.Content;
import tchami.dev.content_calenda.model.Status;
import tchami.dev.content_calenda.model.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content=new ArrayList<>();

    public ContentCollectionRepository() {}

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> finById(Integer id){
        return content.stream().filter(c->c.id().equals(id)).findFirst();
    }

    // create the dummy data by using post constructor

    @PostConstruct
    private void inti() {
        Content c = new Content(1,
                "tchami test data",
                "this is the best description for testing data ",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        content.add(c);
    }
}
