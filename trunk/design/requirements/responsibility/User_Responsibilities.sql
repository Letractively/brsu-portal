drop database if exists User_Responsibilities;

create database User_Responsibilities;
use User_Responsibilities;

create table if not exists responsibilities (
id_responsibilities int not null auto_increment primary key,
name varchar(50)
);

insert into responsibilities values
(null,'Developer'),
(null,'Tester'),
(null,'Designer'),
(null,'Project manager'),
(null,'Team leader'),
(null,'QA specilist'),
(null,'Technical writer'),
(null,'Business analyst');

describe responsibilities;
select * from responsibilities;