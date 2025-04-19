package tchami.dev.content_calenda.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tchami.dev.content_calenda.model.Content;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


//    there is an error here because the model have some constant data
    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Content(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("status"),
                rs.getString("content_type"),
                rs.getTimestamp("date_created"),
                rs.getTimestamp("date_updated"),
                rs.getString("url")
        );
    }

    public List<Content> getAllContents() {
        String sql = "SELECT * FROM Content";
        return jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
    }

    public Content getContentById(int id) {
        String sql = "SELECT * FROM Content WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, ContentJdbcTemplateRepository::mapRow, id);
    }

    public int createContent(
            String title,
            String description,
            String status,
            String contentType,
            Timestamp dateCreated,
            Timestamp dateUpdated,
            String url
    ) {
        String sql = "INSERT INTO Content (title, description, status, content_type, date_created, date_updated, url) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                title,
                description,
                status,
                contentType,
                dateCreated,
                dateUpdated,
                url
        );
    }

    public int updateContent(
            int id,
            String title,
            String description,
            String status,
            String contentType,
            Timestamp dateCreated,
            Timestamp dateUpdated,
            String url
    ) {
        String sql = "UPDATE Content SET title = ?, description = ?, status = ?, content_type = ?, date_created = ?, date_updated = ?, url = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                title,
                description,
                status,
                contentType,
                dateCreated,
                dateUpdated,
                url,
                id
        );
    }

    public int deleteContent(int id) {
        String sql = "DELETE FROM Content WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
