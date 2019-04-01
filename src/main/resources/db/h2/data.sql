insert into author(author_name) values('Eric Evans');
insert into book(title,author_id) values('Domain driven design',(select author_id from author where author_name='Eric Evans'));