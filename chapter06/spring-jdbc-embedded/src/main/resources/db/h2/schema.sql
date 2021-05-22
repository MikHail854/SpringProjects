CREATE TABLE musicdb_schema.singer (
    ID SERIAL NOT NULL
    , FIRST_NAME VARCHAR(60) NOT NULL
    , LAST_NAME VARCHAR(40) NOT NULL
    , BIRTH_DATE DATE
    , CONSTRAINT UQ_SINGER_1 UNIQUE (FIRST_NAME, LAST_NAME)
    , PRIMARY KEY (ID)
);

CREATE TABLE musicdb_schema.album (
    ID SERIAL NOT NULL
    , SINGER_ID INT NOT NULL
    , TITLE VARCHAR(100) NOT NULL
    , RELEASE_DATE DATE
    , CONSTRAINT UQ_SINGER_ALBUM_1 UNIQUE (SINGER_ID, TITLE)
    , PRIMARY KEY (ID)
    , CONSTRAINT FK_ALBUM FOREIGN KEY (SINGER_ID)
        REFERENCES musicdb_schema.singer (ID)
);