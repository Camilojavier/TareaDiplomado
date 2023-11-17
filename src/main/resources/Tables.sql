-- Create user table
CREATE TABLE users (
                        id BIGINT NOT NULL,
                        username VARCHAR(150) NOT NULL,
                        password VARCHAR(150) NOT NULL,
                        email VARCHAR(150) NOT NULL,
                        created_at TIMESTAMP,
                        PRIMARY KEY (id)
);

-- Create a sequence for user id
CREATE SEQUENCE  user_seq AS BIGINT INCREMENT 1;

-- Create user_detail table
CREATE TABLE users_detail (
                             id BIGINT NOT NULL,
                             first_name VARCHAR(100) NOT NULL,
                             last_name VARCHAR(100) NOT NULL,
                             age INTEGER,
                             birthday DATE,
                             user_id BIGINT,
                             PRIMARY KEY (id)
);

ALTER TABLE users_detail ADD CONSTRAINT FK_Detail_RefUser FOREIGN KEY (user_id)
    REFERENCES users (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE SEQUENCE  user_detail_seq AS BIGINT INCREMENT 1;
