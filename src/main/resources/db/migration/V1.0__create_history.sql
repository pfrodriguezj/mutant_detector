CREATE TABLE history (
                         id serial NOT NULL ,
                         dna varchar(16380) NOT NULL,
                         is_mutant boolean NOT NULL,
                         CONSTRAINT history_PK PRIMARY KEY (id)
)
