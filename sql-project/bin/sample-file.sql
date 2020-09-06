--create table sample_table(name varchar(100), age int);

select * from sample_table;

insert into sample_table(name, age) values('example_user', 25);

insert into sample_table(name, age) values('ranjith', 25);

insert into sample_table(name, age) values('danny', 25);

--select * from sample_table;

delete from sample_table where name='danny';

delete from sample_table where name='ranjith';

select * from sample_table;