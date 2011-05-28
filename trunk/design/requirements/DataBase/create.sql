drop database if exists main;
create database main;
use main;

create table users(
id_user int not null auto_increment primary key,
name varchar(25) not null,
surname varchar(50) not null,
email varchar(70) not null,
date_of_birth date null,
telephone varchar(25) null,
password varchar(350) not null,# вписывается хэш код search about MD5
sex int null,
skype varchar(70) null,
isq varchar(70) null,
IQ int null,
id_stat int not null,
picture blob null,
date_of_last_visit date not null,
number_of_cautions smallint null
);


create index IN_ID_USER on users(id_user);
create index IN_NAME_USER on users(name(2));
create index IN_SURNAME_USER on users(surname(2));

create table L_Sites (
id_site int not null auto_increment,# Why not auto_increment key
id_user int not null,
site varchar(300) not null,
foreign key (id_user) references users(id_user),
primary key (id_site)
);

create table status(
id_stat int not null auto_increment primary key,
name varchar(100) not null
);

create table CV(
id_user int not null,
foreign key(id_user) references users(id_user),
hobbies varchar(300) null,
primary key (id_user)
);

create table l_languages_us(
id_user int not null,
id_language int not null,
foreign key(id_user) references users(id_user),
primary key(id_user, id_language)
);

create table CV_links(
id_link int not null auto_increment,# Why can not be auto_increment key?
id_user int not null,
foreign key (id_user) references users(id_user),
link varchar(300) not null,
primary key(id_link)
);

create table technologies(
id_tech int not null auto_increment primary key,
name varchar(100) not null
);

create table l_technologies_us(
id_user int not null,
id_tech int not null,
foreign key (id_user) references users(id_user),
foreign key (id_tech) references technologies(id_tech),
primary key (id_user,id_tech)
);

create table experience(
id_exp int not null auto_increment primary key,
start_date date null,
end_date date null,
company_name varchar(70) null,
position int not null,
additional varchar(3000) null,
id_project int null,
id_user int not null,
foreign key (id_user) references users(id_user)

);

create table type_edu (
id_type_edu int not null auto_increment key,
name varchar(75) not null
);

create table Education(
id_edu int not null auto_increment primary key,
id_user int not null,
start_date date not null,
end_date date null,
edu_name varchar(100) not null,
place varchar(100) not null,
id_type_edu int not null,
additional varchar(3000) null,
foreign key (id_user) references users(id_user),
foreign key (id_type_edu)  references type_edu(id_type_edu)
);

create table categories_pr(
id_category int not null auto_increment primary key,
name varchar(100) not null
);


create table Projects(
id_project int not null auto_increment primary key,
id_owner int not null,
foreign key (id_owner) references users(id_user),
name varchar(100) not null,
description varchar(3000) not null,
date_of_creation date not null,
date_of_closing date null,
id_category int not null,
version int null,
license varchar(3000) null,
stage_of_development varchar(100) not null,
foreign key (id_category) references categories_pr(id_category)
);

create index IN_PR_NAME on Projects(name(2));
create index IN_ID_PR on Projects(id_project);

create table l_technologies_pr(
id_project int not null,
id_tech int not null,
foreign key (id_project) references projects(id_project),
foreign key (id_tech) references technologies(id_tech),
primary key (id_project,id_tech)
);

#create table position(
#id_pos int not null auto_increment key,
#name varchar(100) not null
#);

create table Positions(
id_pos int not null auto_increment key,
name varchar(100) not null
);

create table L_Pos (
id_project int not null, 
id_user int not null,
id_pos int not null,
foreign key (id_project) references projects(id_project),
foreign key (id_user) references users(id_user),
foreign key (id_pos) references Positions(id_pos),
primary key (id_project, id_user)
);

create table tags (
id_tag int not null auto_increment,
id_project int not null,
foreign key(id_project) references projects(id_project),
tag varchar(100) not null,
primary key(id_tag,id_project)
);

create table Language(
id_language int not null auto_increment primary key,
name varchar(100) not null
);

create table l_languages_pr(
id_project int not null,
id_language int not null,
foreign key(id_project) references projects(id_project),
foreign key (id_language) references language (id_language),
primary key (id_project,id_language)
);


create table news (
id_news int not null auto_increment primary key,
title varchar(100) not null,
text text not null,
created_date date,
id_category int not null,
important varchar(30) not null default '',
id_author int not null,
foreign key (id_category) references categories_pr(id_category),
foreign key (id_author) references users(id_user)
);

create index IN_NAME_NEWS on news(title(2)); 

create table Comments_news(
id_comment int not null auto_increment primary key,
id_user int not null,
id_news int not null,
foreign key (id_user) references users(id_user),
foreign key (id_news) references news(id_news),
date_of_creation date not null,
text varchar(3000) not null

);

create table Comments_pr(
id_comment_pr int not null auto_increment primary key,
id_user int not null,
id_project int not null,
foreign key (id_user) references users(id_user),
foreign key (id_project) references projects(id_project),
date_of_creation date not null,
text varchar(3000) not null

);
create table ProjectHistory(
id_pr_history int not null auto_increment primary key,
id_project int not null,
id_user int not null,
foreign key(id_project) references projects(id_project),
foreign key (id_user) references users(id_user),
stage varchar(100) not null,
name varchar(200) not null
);

create table UserHistory(
id_usr_history int not null auto_increment primary key,
id_user int not null,
date date not null,
name varchar(100) not null,
surname varchar(100) not null,
id_status int not null,
iq int null,
number_of_cations int not null,
foreign key (id_user) references users(id_user),
foreign key (id_status) references status(id_stat)
);

create table UserPositionHistory(
id_usr_position_hist int not null auto_increment primary key,
id_user int not null,
foreign key (id_user) references users(id_user),
date date not null,
id_pos int not null,
id_project int not null,
foreign key (id_pos) references Positions(id_pos),
foreign key (id_project) references projects(id_project)
);

create table UserGroup(
id_user_group int not null auto_increment primary key,
name varchar(100) not null
);

create table priority(
id_priority int not null auto_increment primary key,
name varchar(100) not null
);

create table Message(
id_message int not null auto_increment primary key,
title varchar(100) null,
text varchar(3000) not null,
data_m date not null,
id_user_from int not null,
foreign key (id_user_from) references users(id_user),
id_previous_message int null,
is_readed int not null,
priority int not null,
foreign key(priority) references priority(id_priority)
);

create table l_user_to (
id_message int not null,
id_user int not null,
foreign key(id_message) references message(id_message),
foreign key (id_user) references users(id_user),
primary key(id_message,id_user)
);

create table l_user_сс (
id_message int not null,
id_user int not null,
foreign key(id_message) references message(id_message),
foreign key (id_user) references users(id_user),
primary key(id_message,id_user)
);

create table l_user_bcc (
id_message int not null,
id_user int not null,
foreign key(id_message) references message(id_message),
foreign key (id_user) references users(id_user),
primary key(id_message,id_user)
);

alter table users 
add foreign key (id_stat) references status(id_stat),
add id_user_group int not null,
add foreign key (id_user_group) references UserGroup(id_user_group)
;

alter table l_languages_us
add foreign key (id_language) references language(id_language);

alter table Experience
add foreign key (id_project) references projects(id_project),
add foreign key (position) references Positions(id_pos);

 
