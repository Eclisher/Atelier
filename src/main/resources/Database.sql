
CREATE DATABASE studentdb;
\c studentdb;

CREATE TABLE student (
                         id SERIAL PRIMARY KEY,
                         nom VARCHAR(100) NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL
);
INSERT INTO student (nom, email) VALUES
                                     ('Ando Rakoto', 'ando.rakoto@example.com'),
                                     ('Mialy Rabe', 'mialy.rabe@example.com');