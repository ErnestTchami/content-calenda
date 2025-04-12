package tchami.dev.content_calenda.repository;

import org.springframework.stereotype.Repository;
import tchami.dev.content_calenda.model.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRespository {
    private final List<Content> content=new ArrayList<>();

    public ContentCollectionRespository() {}

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> finById(Integer id){
        return content.stream().filter(c->c.id().equals(id)).findFirst();
    }
}
