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
    private final List<Content> contentList =new ArrayList<>();

    public ContentCollectionRepository() {}

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> finById(Integer id){
        return contentList.stream().filter(c->c.id().equals(id)).findFirst();
    }

    // create the dummy data by using post constructor



    public  void add(Content content){
        contentList.removeIf(c->c.id().equals(content.id()));
        contentList.add(content);
    }


//    add the initial value for my API
    @PostConstruct
    private void inti() {
        Content content = new Content(1,
                "tchami test data",
                "this is the best description for testing data ",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c->c.id().equals(id)).count() ==1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c->c.id().equals(id));
    }
}
