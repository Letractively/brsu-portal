use main;

insert into status values(null, 'banned');
insert into status values(null, 'active');
insert into status values(null, 'not active');

select * from status;

insert into technologies values (null, '.NET');
insert into technologies values (null, 'ActiveX');
insert into technologies values (null, 'JDBS');
insert into technologies values (null, 'DirectX');
insert into technologies values (null, 'ASP');

insert into type_edu values (null, 'primary school');
insert into type_edu values (null, 'Secondary school');
insert into type_edu values (null, 'High school');
insert into type_edu values (null, 'Magistratum');
insert into type_edu values (null, 'Doctoratum');
insert into type_edu values (null, 'Evning School))');

insert into categories_pr values (null, 'Medicine');
insert into categories_pr values (null, 'Education');
insert into categories_pr values (null, 'Financy');
insert into categories_pr values (null, 'Service');
insert into categories_pr values (null, 'IT');

insert into Positions values (null, 'Developer');
insert into Positions values (null, 'Tester');
insert into Positions values (null, 'Designer');
insert into Positions values (null, 'Project manager');
insert into Positions values (null, 'Team Leader');
insert into Positions values (null, 'QA Specialist');
insert into Positions values (null, 'Technical writer');
insert into Positions values (null, 'Bisyness analyst');

insert into Language values (null, 'C_Sharp');
insert into Language values (null, 'C++');
insert into Language values (null, 'F#');
insert into Language values (null, 'Java');

insert into UserGroup values (null, 'USer');
insert into UserGroup values (null, 'Moderator');
insert into UserGroup values (null, 'Admin');

insert into Priority values (null, 'Customary');
insert into Priority values (null, 'Important');
insert into Priority values (null, 'Very Important');
insert into Priority values (null, 'Arhi Important');


insert into users values (
null,
'Oleg',
'Panasyuk',
'oleg.panasyuk@inbox.ru',
'1989.08.09',
'+375336426294',
'password',
1,
'oleg.panasyuk89',
'409122811',
100,
1,
'',
'2011.05.21',
5,
3
);

insert into users values (
null,
'IVAN',
'RUSSIAN',
'oleg.panasyuk@inbox.ru',
'1989.08.09',
'+375336426294',
'password',
1,
'oleg.panasyuk89',
'409122811',
100,
1,
'',
'2011.05.21',
5,
2
);

insert into users values (
null,
'Robyn',
'Scherbatzky',
'RobSche@inbox.ru',
'1980.02.09',
'+375336426294',
'password',
0,
'rob',
'432122811',
100,
1,
'',
'2011.05.21',
5,
1
);

insert into users values (
null,
'Ted',
'Mozeby',
'TMOZ@inbox.ru',
'1987.12.03',
'+375336426294',
'password',
1,
'oleg.panasyuk89',
'409122811',
100,
1,
'',
'2011.05.21',
5,
1
);
select * from users;

insert into L_sites values(null, 2, 'vkontakte.ru/id123456789');
insert into L_sites values(null, 4, 'vkontakte.ru/id125456789');
insert into L_sites values(null, 3, 'vkontakte.ru/id123456324');

insert into CV values(2, 'Drinling Vodka and writing code at same time');
insert into CV values(1, 'C#, Java, Girls, Games, Swimming');
insert into CV values(3, 'Watching TV');

insert into l_languages_us values (1 , 4);
insert into l_languages_us values (1 , 2);
insert into l_languages_us values (2 , 4);
insert into l_languages_us values (3 , 4);
insert into l_languages_us values (4 , 4);

insert into Cv_links values (null, 1, 'brsu.portal.by');
insert into Cv_links values (null, 1, 'brgu.portal.by');
insert into Cv_links values (null, 2, 'bgu.portal.by');

insert into l_technologies_us values (1 , 4);
insert into l_technologies_us values (1 , 2);
insert into l_technologies_us values (2 , 4);
insert into l_technologies_us values (3 , 5);
insert into l_technologies_us values (4 , 3);

insert into experience values (null, '2011.05.01', null, 'brsu', 1, 'good worker', null ,1);
insert into experience values (null, '2011.05.01', null, 'brsu', 2, 'bad worker', null ,2);
insert into experience values (null, '2011.05.01', null, 'brsu', 1, 'so-so worker', null ,3);
insert into experience values (null, '2011.05.01', null, 'brsu', 2, 'ideal worker', null ,2);
insert into experience values (null, '2011.05.01', null, 'coca_cola', 1, 'good worker', null ,4);

insert into Education values (null, 1, '2007.09.01', null, 'BRGU', 'Brest', 3, 'good student');
insert into Education values (null, 2, '2007.09.01', null, 'BRGU', 'Brest', 3, 'bad student');

insert into projects values (null, 1, 'test', 'tested project', '2011.05.01', '2011.05.02', 1, 1, null, 'alpha-test');

insert into l_technologies_pr values (1,3);
insert into l_technologies_pr values (1,2);

insert into L_Pos values (1,1,1);
insert into L_Pos values (1,2,1);
insert into L_Pos values (1,3,2);

insert into tags values (null, 1, 'tested');
insert into tags values (null, 1, 'cool');

insert into l_languages_pr values(1,2);

insert into news values (null,'Obyavleny laureaty\n shestoi "Premii Runeta"',
'V Moskve\n v GKZ "Pushkinskii"
 vecherom\n 25 noyabrya byla vruchena 
 "Premiya\n Runeta-2009". Ee laureatami stali
 organizacii\n i internet-saity v shesti\n
 nominaciyah.','2009-09-25',2,'',1);
insert into news values (null,'V Seti poyavitsya virtualnyi mir dlya muzykantov',
'V fevrale 2009 goda otkroetsya
 socialnaya seti Music Mogul','2009-10-09',1,'',1);
insert into news values (null,' Poteryan disk s lichnymi dannymi tysyach sotrudnikov shkol',
'Upravlenie gosudarstvennyh shkol
 kanadskogo goroda Edmonton soobschilo
 o sereznoi utechke dannyh tysyach svoih
 sotrudnikov. Dannye bolee chem 7 tys.
 chelovek nahodilis na flesh-diske,
 kotoryi ispolzovalsya sotrudnikom otdela
 kadrov i byl poteryan im 22 marta tekuschego goda. ','2011-04-11',2,'',2);                                                                                                                                                                                                                                                           
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
 1,
 '',
 2);
insert into news values (null,'Gosudarstvo gotovit lgoty dlya rossiiskih programmistov',
'Kak stalo izvestno RBK daily, v Minkomsvyazi
 gotovitsya proekt resheniya o predostavlenii
 lgot proizvoditelyam programmnogo obespecheniya,
 kotorye razmestyat centry razrabotki v Rossii.
 V chastnosti, im budet prosche vyigrat tendery dlya gosstruktur.','2011-04-20',2,'',3);
insert into news values(null,'U sobaki sozdatelya Facebook poyavilsya svoi akkaunt',
'Mark Cukerberg, sozdatel vsemirno izvestnoi socialnoi
 seti Facebook, zavel stranichku dlya svoei
 sobaki po klichke Bist (Beast). Sobaka za neskolko
 chasov “dobavila v druzya” bolee dvuh tysyach chelovek.','2011-04-02',3,'',3);                                                                                                                                                                                                                                                                                                                                                                                                       

   
 insert into Comments_news values (null, 1, 2, '2011.05.25', 'Session soon');
 insert into Comments_news values (null, 2, 3, '2011.05.27', 'Session soon2');
 insert into Comments_news values (null, 4, 4, '2011.05.26', 'I commented this post');

insert into Comments_pr values (null, 2, 1, '2011.05.25', 'I commented this project');
insert into Comments_pr values (null, 3, 1, '2011.05.27', 'I commented this project');
insert into Comments_pr values (null, 2, 1, '2011.05.27', 'I commented this project second time');

insert into ProjectHistory values ( null, 1, 1, 'Finished', 'Coca-cola');

insert into UserHistory values (null, 1, '2011.05.28', 'Oleg','Panassyuk',1, 110,0);
insert into UserHistory values (null, 2, '2011.05.28', 'Ivan','Belarus',1, 120,1);

insert into UserPositionHistory values (null, 1, '2011.05.28', 3, 1);

insert into Message values (
null,
'Hello!',
'We are greating you on our web-site)',
'2011.05.28',
1,
null,
0,
1
);
insert into Message values (
null,
'Hello!',
'Let\'s go to bar. I found a new client. He want to meet us and discusse work.',
'2011.05.28',
2,
null,
0,
2
);
insert into Message values (
null,
'Hello!',
'I saw your work on project. I think that is good. I want to see the same on my web-site.',
'2011.05.28',
3,
null,
1,
1
);

insert into l_user_to values (1, 2);
insert into l_user_to values (1, 3);
insert into l_user_to values (1, 4);
insert into l_user_to values (2, 2);
insert into l_user_to values (3, 4);



