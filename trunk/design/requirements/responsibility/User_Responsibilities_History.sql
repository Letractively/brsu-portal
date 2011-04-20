drop database if exists User_Responsibilities_History;

create database User_Responsibilities_History;
use User_Responsibilities_History;

create table if not exists responsibilities_history (
id_usr_resp_history int not null auto_increment key,
id_user int not null references UserHistory(id_user),
date_historu date,
responsibility int not null references responsibilities(id_responsibilities)
);

describe responsibilities_history;
select * from responsibilities_history;