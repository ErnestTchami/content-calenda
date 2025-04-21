package tchami.dev.content_calenda.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import tchami.dev.content_calenda.model.Content;
import tchami.dev.content_calenda.model.Status;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {

    List<Content>findAllByTitleContains(String keyword);

    @Query("""
    SELECT * FROM Content
    WHERE status= :status
    """)
    List<Content>listAllByStatus(@Param("status") Status status);
}
