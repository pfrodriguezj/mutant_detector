CREATE TABLE history (
                         id int NOT NULL AUTO_INCREMENT,
                         dna varchar(16380) NOT NULL,
                         is_mutant bit NOT NULL,
                         CONSTRAINT history_PK PRIMARY KEY (id)
)

