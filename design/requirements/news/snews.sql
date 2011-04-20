drop database if exists snews;
create database snews;
use snews;

create table news (
id_news int not null auto_increment key,
title varchar(100) not null,
text varchar(5000) not null,
created date,
news_category varchar(50) not null,
important varchar(30) not null default '',
author_id int);

create table authors (
author_id int not null auto_increment key,
sername varchar(20) not null,
name varchar(20) not null); 


insert into authors values (null,'Petrov','Sasha') ;
insert into authors values(null,'Ivanov','Ivan');
insert into authors values(null,'Sidorov','Sergey');

insert into news values (null,'Obyavleny laureaty\n shestoi "Premii Runeta"',
'V Moskve\n v GKZ "Pushkinskii"
 vecherom\n 25 noyabrya byla vruchena 
 "Premiya\n Runeta-2009". Ee laureatami stali
 organizacii\n i internet-saity v shesti\n
 nominaciyah.','2009-09-25','Internet i seti','',1);
insert into news values (null,'V Seti poyavitsya virtualnyi mir dlya muzykantov',
'V fevrale 2009 goda otkroetsya
 socialnaya seti Music Mogul','2009-10-09','Internet i seti','',1);
insert into news values (null,' Poteryan disk s lichnymi dannymi tysyach sotrudnikov shkol',
'Upravlenie gosudarstvennyh shkol
 kanadskogo goroda Edmonton soobschilo
 o sereznoi utechke dannyh tysyach svoih
 sotrudnikov. Dannye bolee chem 7 tys.
 chelovek nahodilis na flesh-diske,
 kotoryi ispolzovalsya sotrudnikom otdela
 kadrov i byl poteryan im 22 marta tekuschego goda. ','2011-04-11','Bezopasnost','',2);                                                                                                                                                                                                                                                           
insert into news values (null,' 
Novaya modifikaciya troyana Android.
Spy prevraschaet smartfon v "zombi"',
'Kompaniya "Doktor Veb" — rossiiskii 
razrabotchik sredstv informacionnoi bezopasnosti
 — soobschila ob obnarujenii 12 aprelya novoi
 modifikacii vredonosnoi programmy semeistva
 Android.Spy, predstavlyayuschei opasnost dlya
 vladelcev smartfonov na baze OS Android.',
 '2011-04-15',
 'Bezopasnost',
 '',
 2);
insert into news values (null,'Gosudarstvo gotovit lgoty dlya rossiiskih programmistov',
'Kak stalo izvestno RBK daily, v Minkomsvyazi
 gotovitsya proekt resheniya o predostavlenii
 lgot proizvoditelyam programmnogo obespecheniya,
 kotorye razmestyat centry razrabotki v Rossii.
 V chastnosti, im budet prosche vyigrat tendery dlya gosstruktur.','2011-04-20','Sovremennoe programmirovanie - Poslednie novosti','',3);
insert into news values(null,'U sobaki sozdatelya Facebook poyavilsya svoi akkaunt',
'Mark Cukerberg, sozdatel vsemirno izvestnoi socialnoi
 seti Facebook, zavel stranichku dlya svoei
 sobaki po klichke Bist (Beast). Sobaka za neskolko
 chasov “dobavila v druzya” bolee dvuh tysyach chelovek.','2011-04-02','Sovremennoe programmirovanie - Poslednie novosti','',3);                                                                                                                                                                                                                                                                                                                                                                                                       

   
 