drop table author if exists;
drop table book if exists;

create table author (
author_id binary identity primary key,
author_name varchar(100)
);

create table book (
book_id binary identity primary key,
title varchar(100),
author_id binary not null);

create index idx_book_author on book(author_id);
alter table book add constraint fk_book_author foreign key (author_id) references author(author_id);