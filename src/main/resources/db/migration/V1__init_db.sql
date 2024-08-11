CREATE SEQUENCE IF NOT EXISTS seq_note_id
    START WITH 1
    INCREMENT BY 1;


CREATE TABLE IF NOT EXISTS notes
(
    id  BIGINT DEFAULT nextval('seq_note_id'),
    title VARCHAR(255),
    content varchar(255) CHECK(LENGTH(title)>=3 AND LENGTH(title)<=250),
    CONSTRAINT pk_notes_id PRIMARY KEY (id)
);