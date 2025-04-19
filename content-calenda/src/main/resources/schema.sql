CREATE TABLE IF NOT EXISTS Content (
    id             INT AUTO_INCREMENT PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    description    TEXT,
    status         VARCHAR(20) NOT NULL,
    content_type   VARCHAR(50) NOT NULL,
    date_created   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_updated   TIMESTAMP         DEFAULT NULL,
    url            VARCHAR(255)
    );

INSERT INTO Content (
    title,
    description,
    status,
    content_type,
    date_created
) VALUES (
             'Best',
             'THIS is the best title data',
             'IDEA',
             'ARTICLE',
             CURRENT_TIMESTAMP
         );
