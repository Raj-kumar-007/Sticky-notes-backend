CREATE TABLE Notes
(
    Id          UUID            DEFAULT UUID()      NOT NULL PRIMARY KEY,
    UserId      UUID            DEFAULT UUID()      NOT NULL            ,
    Note        varchar(10000)  DEFAULT ''
);