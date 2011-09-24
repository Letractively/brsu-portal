# --------------------------------------------------------
# Host:                         127.0.0.1
# Server version:               5.5.14
# Server OS:                    Win32
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2011-07-28 15:54:04
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for portal
CREATE DATABASE IF NOT EXISTS `portal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `portal`;


# Dumping structure for table portal.categories_pr
CREATE TABLE IF NOT EXISTS `categories_pr` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

# Dumping data for table portal.categories_pr: ~5 rows (approximately)
/*!40000 ALTER TABLE `categories_pr` DISABLE KEYS */;
INSERT INTO `categories_pr` (`id_category`, `name`) VALUES
	(1, 'Medicine'),
	(2, 'Education'),
	(3, 'Financy'),
	(4, 'Service'),
	(5, 'IT');
/*!40000 ALTER TABLE `categories_pr` ENABLE KEYS */;


# Dumping structure for table portal.comments_news
CREATE TABLE IF NOT EXISTS `comments_news` (
  `id_comment` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_news` int(11) NOT NULL,
  `date_of_creation` date NOT NULL,
  `text` varchar(3000) NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `id_user` (`id_user`),
  KEY `id_news` (`id_news`),
  CONSTRAINT `comments_news_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `comments_news_ibfk_2` FOREIGN KEY (`id_news`) REFERENCES `news` (`id_news`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

# Dumping data for table portal.comments_news: ~3 rows (approximately)
/*!40000 ALTER TABLE `comments_news` DISABLE KEYS */;
INSERT INTO `comments_news` (`id_comment`, `id_user`, `id_news`, `date_of_creation`, `text`) VALUES
	(1, 1, 2, '2011-05-25', 'Session soon'),
	(2, 2, 3, '2011-05-27', 'Session soon2'),
	(3, 4, 4, '2011-05-26', 'I commented this post');
/*!40000 ALTER TABLE `comments_news` ENABLE KEYS */;


# Dumping structure for table portal.comments_pr
CREATE TABLE IF NOT EXISTS `comments_pr` (
  `id_comment_pr` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  `date_of_creation` date NOT NULL,
  `text` varchar(3000) NOT NULL,
  PRIMARY KEY (`id_comment_pr`),
  KEY `id_user` (`id_user`),
  KEY `id_project` (`id_project`),
  CONSTRAINT `comments_pr_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `comments_pr_ibfk_2` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id_project`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

# Dumping data for table portal.comments_pr: ~3 rows (approximately)
/*!40000 ALTER TABLE `comments_pr` DISABLE KEYS */;
INSERT INTO `comments_pr` (`id_comment_pr`, `id_user`, `id_project`, `date_of_creation`, `text`) VALUES
	(1, 2, 1, '2011-05-25', 'I commented this project'),
	(2, 3, 1, '2011-05-27', 'I commented this project'),
	(3, 2, 1, '2011-05-27', 'I commented this project second time');
/*!40000 ALTER TABLE `comments_pr` ENABLE KEYS */;


# Dumping structure for table portal.cv
CREATE TABLE IF NOT EXISTS `cv` (
  `id_user` int(11) NOT NULL,
  `hobbies` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  CONSTRAINT `cv_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.cv: ~3 rows (approximately)
/*!40000 ALTER TABLE `cv` DISABLE KEYS */;
INSERT INTO `cv` (`id_user`, `hobbies`) VALUES
	(1, 'C#, Java, Girls, Games, Swimming'),
	(2, 'Drinling Vodka and writing code at same time'),
	(3, 'Watching TV');
/*!40000 ALTER TABLE `cv` ENABLE KEYS */;


# Dumping structure for table portal.cv_links
CREATE TABLE IF NOT EXISTS `cv_links` (
  `id_link` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `link` varchar(300) NOT NULL,
  PRIMARY KEY (`id_link`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `cv_links_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

# Dumping data for table portal.cv_links: ~3 rows (approximately)
/*!40000 ALTER TABLE `cv_links` DISABLE KEYS */;
INSERT INTO `cv_links` (`id_link`, `id_user`, `link`) VALUES
	(1, 1, 'brsu.portal.by'),
	(2, 1, 'brgu.portal.by'),
	(3, 2, 'bgu.portal.by');
/*!40000 ALTER TABLE `cv_links` ENABLE KEYS */;


# Dumping structure for table portal.education
CREATE TABLE IF NOT EXISTS `education` (
  `id_edu` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `edu_name` varchar(100) NOT NULL,
  `place` varchar(100) NOT NULL,
  `id_type_edu` int(11) NOT NULL,
  `additional` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id_edu`),
  KEY `id_user` (`id_user`),
  KEY `id_type_edu` (`id_type_edu`),
  CONSTRAINT `education_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `education_ibfk_2` FOREIGN KEY (`id_type_edu`) REFERENCES `type_edu` (`id_type_edu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table portal.education: ~2 rows (approximately)
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` (`id_edu`, `id_user`, `start_date`, `end_date`, `edu_name`, `place`, `id_type_edu`, `additional`) VALUES
	(1, 1, '2007-09-01', NULL, 'BRGU', 'Brest', 3, 'good student'),
	(2, 2, '2007-09-01', NULL, 'BRGU', 'Brest', 3, 'bad student');
/*!40000 ALTER TABLE `education` ENABLE KEYS */;


# Dumping structure for table portal.experience
CREATE TABLE IF NOT EXISTS `experience` (
  `id_exp` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `company_name` varchar(70) DEFAULT NULL,
  `position` int(11) NOT NULL,
  `additional` varchar(3000) DEFAULT NULL,
  `id_project` int(11) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_exp`),
  KEY `id_user` (`id_user`),
  KEY `id_project` (`id_project`),
  KEY `position` (`position`),
  CONSTRAINT `experience_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `experience_ibfk_2` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id_project`),
  CONSTRAINT `experience_ibfk_3` FOREIGN KEY (`position`) REFERENCES `positions` (`id_pos`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

# Dumping data for table portal.experience: ~5 rows (approximately)
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` (`id_exp`, `start_date`, `end_date`, `company_name`, `position`, `additional`, `id_project`, `id_user`) VALUES
	(1, '2011-05-01', NULL, 'brsu', 1, 'good worker', NULL, 1),
	(2, '2011-05-01', NULL, 'brsu', 2, 'bad worker', NULL, 2),
	(3, '2011-05-01', NULL, 'brsu', 1, 'so-so worker', NULL, 3),
	(4, '2011-05-01', NULL, 'brsu', 2, 'ideal worker', NULL, 2),
	(5, '2011-05-01', NULL, 'coca_cola', 1, 'good worker', NULL, 4);
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;


# Dumping structure for table portal.jobs
CREATE TABLE IF NOT EXISTS `jobs` (
  `id_job` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `id_owner` int(11) NOT NULL,
  `text` varchar(400) NOT NULL,
  `id_project` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_job`),
  KEY `id_owner` (`id_owner`),
  KEY `id_project` (`id_project`),
  CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`id_owner`) REFERENCES `users` (`id_user`),
  CONSTRAINT `jobs_ibfk_2` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id_project`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.jobs: ~0 rows (approximately)
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;


# Dumping structure for table portal.language
CREATE TABLE IF NOT EXISTS `language` (
  `id_language` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_language`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

# Dumping data for table portal.language: ~4 rows (approximately)
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` (`id_language`, `name`) VALUES
	(1, 'C_Sharp'),
	(2, 'C++'),
	(3, 'F#'),
	(4, 'Java');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;


# Dumping structure for table portal.l_languages_pr
CREATE TABLE IF NOT EXISTS `l_languages_pr` (
  `id_project` int(11) NOT NULL,
  `id_language` int(11) NOT NULL,
  PRIMARY KEY (`id_project`,`id_language`),
  KEY `id_language` (`id_language`),
  CONSTRAINT `l_languages_pr_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id_project`),
  CONSTRAINT `l_languages_pr_ibfk_2` FOREIGN KEY (`id_language`) REFERENCES `language` (`id_language`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_languages_pr: ~1 rows (approximately)
/*!40000 ALTER TABLE `l_languages_pr` DISABLE KEYS */;
INSERT INTO `l_languages_pr` (`id_project`, `id_language`) VALUES
	(1, 2);
/*!40000 ALTER TABLE `l_languages_pr` ENABLE KEYS */;


# Dumping structure for table portal.l_languages_us
CREATE TABLE IF NOT EXISTS `l_languages_us` (
  `id_user` int(11) NOT NULL,
  `id_language` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_language`),
  KEY `id_language` (`id_language`),
  CONSTRAINT `l_languages_us_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `l_languages_us_ibfk_2` FOREIGN KEY (`id_language`) REFERENCES `language` (`id_language`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_languages_us: ~5 rows (approximately)
/*!40000 ALTER TABLE `l_languages_us` DISABLE KEYS */;
INSERT INTO `l_languages_us` (`id_user`, `id_language`) VALUES
	(1, 2),
	(1, 4),
	(2, 4),
	(3, 4),
	(4, 4);
/*!40000 ALTER TABLE `l_languages_us` ENABLE KEYS */;


# Dumping structure for table portal.l_lang_jobs
CREATE TABLE IF NOT EXISTS `l_lang_jobs` (
  `id_language` int(11) NOT NULL,
  `id_job` int(11) NOT NULL,
  PRIMARY KEY (`id_language`,`id_job`),
  KEY `id_job` (`id_job`),
  CONSTRAINT `l_lang_jobs_ibfk_1` FOREIGN KEY (`id_job`) REFERENCES `jobs` (`id_job`),
  CONSTRAINT `l_lang_jobs_ibfk_2` FOREIGN KEY (`id_language`) REFERENCES `language` (`id_language`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_lang_jobs: ~0 rows (approximately)
/*!40000 ALTER TABLE `l_lang_jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `l_lang_jobs` ENABLE KEYS */;


# Dumping structure for table portal.l_pos
CREATE TABLE IF NOT EXISTS `l_pos` (
  `id_project` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_pos` int(11) NOT NULL,
  PRIMARY KEY (`id_project`,`id_user`),
  KEY `id_user` (`id_user`),
  KEY `id_pos` (`id_pos`),
  CONSTRAINT `l_pos_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id_project`),
  CONSTRAINT `l_pos_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `l_pos_ibfk_3` FOREIGN KEY (`id_pos`) REFERENCES `positions` (`id_pos`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_pos: ~3 rows (approximately)
/*!40000 ALTER TABLE `l_pos` DISABLE KEYS */;
INSERT INTO `l_pos` (`id_project`, `id_user`, `id_pos`) VALUES
	(1, 1, 1),
	(1, 2, 1),
	(1, 3, 2);
/*!40000 ALTER TABLE `l_pos` ENABLE KEYS */;


# Dumping structure for table portal.l_sites
CREATE TABLE IF NOT EXISTS `l_sites` (
  `id_site` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `site` varchar(300) NOT NULL,
  PRIMARY KEY (`id_site`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `l_sites_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_sites: ~3 rows (approximately)
/*!40000 ALTER TABLE `l_sites` DISABLE KEYS */;
INSERT INTO `l_sites` (`id_site`, `id_user`, `site`) VALUES
	(1, 2, 'vkontakte.ru/id123456789'),
	(2, 4, 'vkontakte.ru/id125456789'),
	(3, 3, 'vkontakte.ru/id123456324');
/*!40000 ALTER TABLE `l_sites` ENABLE KEYS */;


# Dumping structure for table portal.l_technologies_pr
CREATE TABLE IF NOT EXISTS `l_technologies_pr` (
  `id_project` int(11) NOT NULL,
  `id_tech` int(11) NOT NULL,
  PRIMARY KEY (`id_project`,`id_tech`),
  KEY `id_tech` (`id_tech`),
  CONSTRAINT `l_technologies_pr_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id_project`),
  CONSTRAINT `l_technologies_pr_ibfk_2` FOREIGN KEY (`id_tech`) REFERENCES `technologies` (`id_tech`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_technologies_pr: ~2 rows (approximately)
/*!40000 ALTER TABLE `l_technologies_pr` DISABLE KEYS */;
INSERT INTO `l_technologies_pr` (`id_project`, `id_tech`) VALUES
	(1, 2),
	(1, 3);
/*!40000 ALTER TABLE `l_technologies_pr` ENABLE KEYS */;


# Dumping structure for table portal.l_technologies_us
CREATE TABLE IF NOT EXISTS `l_technologies_us` (
  `id_user` int(11) NOT NULL,
  `id_tech` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_tech`),
  KEY `id_tech` (`id_tech`),
  CONSTRAINT `l_technologies_us_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `l_technologies_us_ibfk_2` FOREIGN KEY (`id_tech`) REFERENCES `technologies` (`id_tech`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_technologies_us: ~5 rows (approximately)
/*!40000 ALTER TABLE `l_technologies_us` DISABLE KEYS */;
INSERT INTO `l_technologies_us` (`id_user`, `id_tech`) VALUES
	(1, 2),
	(4, 3),
	(1, 4),
	(2, 4),
	(3, 5);
/*!40000 ALTER TABLE `l_technologies_us` ENABLE KEYS */;


# Dumping structure for table portal.l_tech_jobs
CREATE TABLE IF NOT EXISTS `l_tech_jobs` (
  `id_tech` int(11) NOT NULL,
  `id_job` int(11) NOT NULL,
  PRIMARY KEY (`id_job`,`id_tech`),
  KEY `id_tech` (`id_tech`),
  CONSTRAINT `l_tech_jobs_ibfk_1` FOREIGN KEY (`id_tech`) REFERENCES `technologies` (`id_tech`),
  CONSTRAINT `l_tech_jobs_ibfk_2` FOREIGN KEY (`id_job`) REFERENCES `jobs` (`id_job`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_tech_jobs: ~0 rows (approximately)
/*!40000 ALTER TABLE `l_tech_jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `l_tech_jobs` ENABLE KEYS */;


# Dumping structure for table portal.l_user_bcc
CREATE TABLE IF NOT EXISTS `l_user_bcc` (
  `id_message` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_message`,`id_user`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `l_user_bcc_ibfk_1` FOREIGN KEY (`id_message`) REFERENCES `message` (`id_message`),
  CONSTRAINT `l_user_bcc_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_user_bcc: ~0 rows (approximately)
/*!40000 ALTER TABLE `l_user_bcc` DISABLE KEYS */;
/*!40000 ALTER TABLE `l_user_bcc` ENABLE KEYS */;


# Dumping structure for table portal.l_user_to
CREATE TABLE IF NOT EXISTS `l_user_to` (
  `id_message` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_message`,`id_user`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `l_user_to_ibfk_1` FOREIGN KEY (`id_message`) REFERENCES `message` (`id_message`),
  CONSTRAINT `l_user_to_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_user_to: ~5 rows (approximately)
/*!40000 ALTER TABLE `l_user_to` DISABLE KEYS */;
INSERT INTO `l_user_to` (`id_message`, `id_user`) VALUES
	(1, 2),
	(2, 2),
	(1, 3),
	(1, 4),
	(3, 4);
/*!40000 ALTER TABLE `l_user_to` ENABLE KEYS */;


# Dumping structure for table portal.l_user_сс
CREATE TABLE IF NOT EXISTS `l_user_сс` (
  `id_message` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_message`,`id_user`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `l_user_@x0@x0_ibfk_1` FOREIGN KEY (`id_message`) REFERENCES `message` (`id_message`),
  CONSTRAINT `l_user_@x0@x0_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table portal.l_user_сс: ~0 rows (approximately)
/*!40000 ALTER TABLE `l_user_сс` DISABLE KEYS */;
/*!40000 ALTER TABLE `l_user_сс` ENABLE KEYS */;


# Dumping structure for table portal.message
CREATE TABLE IF NOT EXISTS `message` (
  `id_message` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `text` varchar(3000) NOT NULL,
  `data_m` date NOT NULL,
  `id_user_from` int(11) NOT NULL,
  `id_previous_message` boolean,
  `is_readed` boolean,
  `priority` int(11) NOT NULL,
  PRIMARY KEY (`id_message`),
  KEY `id_user_from` (`id_user_from`),
  KEY `priority` (`priority`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`id_user_from`) REFERENCES `users` (`id_user`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`priority`) REFERENCES `priority` (`id_priority`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

# Dumping data for table portal.message: ~3 rows (approximately)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`title`, `text`, `data_m`, `id_user_from`, `id_previous_message`, `is_readed`, `priority`) VALUES
	('Hello!', 'We are greating you on our web-site)', '2011-05-28', 1, false, false, 1),
	('Hello!', 'Let\'s go to bar. I found a new client. He want to meet us and discusse work.', '2011-05-28', 2, false, false, 2),
	('Hello!', 'I saw your work on project. I think that is good. I want to see the same on my web-site.', '2011-05-28', 3, false, true, 1);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


# Dumping structure for table portal.news
CREATE TABLE IF NOT EXISTS `news` (
  `id_news` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `text` text NOT NULL,
  `created_date` date DEFAULT NULL,
  `id_category` int(11) NOT NULL,
  `important` varchar(30) NOT NULL DEFAULT '',
  `id_author` int(11) NOT NULL,
  PRIMARY KEY (`id_news`),
  KEY `id_category` (`id_category`),
  KEY `id_author` (`id_author`),
  KEY `IN_NAME_NEWS` (`title`(2)),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `categories_pr` (`id_category`),
  CONSTRAINT `news_ibfk_2` FOREIGN KEY (`id_author`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

# Dumping data for table portal.news: ~6 rows (approximately)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id_news`, `title`, `text`, `created_date`, `id_category`, `important`, `id_author`) VALUES
	(1, 'Obyavleny laureaty\n shestoi "Premii Runeta"', 'V Moskve\n v GKZ "Pushkinskii"\r\n vecherom\n 25 noyabrya byla vruchena \r\n "Premiya\n Runeta-2009". Ee laureatami stali\r\n organizacii\n i internet-saity v shesti\n\r\n nominaciyah.', '2009-09-25', 2, '', 1),
	(2, 'V Seti poyavitsya virtualnyi mir dlya muzykantov', 'V fevrale 2009 goda otkroetsya\r\n socialnaya seti Music Mogul', '2009-10-09', 1, '', 1),
	(3, ' Poteryan disk s lichnymi dannymi tysyach sotrudnikov shkol', 'Upravlenie gosudarstvennyh shkol\r\n kanadskogo goroda Edmonton soobschilo\r\n o sereznoi utechke dannyh tysyach svoih\r\n sotrudnikov. Dannye bolee chem 7 tys.\r\n chelovek nahodilis na flesh-diske,\r\n kotoryi ispolzovalsya sotrudnikom otdela\r\n kadrov i byl poteryan im 22 marta tekuschego goda. ', '2011-04-11', 2, '', 2),
	(4, ' \r\nNovaya modifikaciya troyana Android.\r\nSpy prevraschaet smartfon v "zombi"', 'Kompaniya "Doktor Veb" — rossiiskii \r\nrazrabotchik sredstv informacionnoi bezopasnosti\r\n — soobschila ob obnarujenii 12 aprelya novoi\r\n modifikacii vredonosnoi programmy semeistva\r\n Android.Spy, predstavlyayuschei opasnost dlya\r\n vladelcev smartfonov na baze OS Android.', '2011-04-15', 1, '', 2),
	(5, 'Gosudarstvo gotovit lgoty dlya rossiiskih programmistov', 'Kak stalo izvestno RBK daily, v Minkomsvyazi\r\n gotovitsya proekt resheniya o predostavlenii\r\n lgot proizvoditelyam programmnogo obespecheniya,\r\n kotorye razmestyat centry razrabotki v Rossii.\r\n V chastnosti, im budet prosche vyigrat tendery dlya gosstruktur.', '2011-04-20', 2, '', 3),
	(6, 'U sobaki sozdatelya Facebook poyavilsya svoi akkaunt', 'Mark Cukerberg, sozdatel vsemirno izvestnoi socialnoi\r\n seti Facebook, zavel stranichku dlya svoei\r\n sobaki po klichke Bist (Beast). Sobaka za neskolko\r\n chasov “dobavila v druzya” bolee dvuh tysyach chelovek.', '2011-04-02', 3, '', 3);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


# Dumping structure for table portal.positions
CREATE TABLE IF NOT EXISTS `positions` (
  `id_pos` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_pos`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

# Dumping data for table portal.positions: ~8 rows (approximately)
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` (`id_pos`, `name`) VALUES
	(1, 'Developer'),
	(2, 'Tester'),
	(3, 'Designer'),
	(4, 'Project manager'),
	(5, 'Team Leader'),
	(6, 'QA Specialist'),
	(7, 'Technical writer'),
	(8, 'Bisyness analyst');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;


# Dumping structure for table portal.priority
CREATE TABLE IF NOT EXISTS `priority` (
  `id_priority` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_priority`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

# Dumping data for table portal.priority: ~4 rows (approximately)
/*!40000 ALTER TABLE `priority` DISABLE KEYS */;
INSERT INTO `priority` (`id_priority`, `name`) VALUES
	(1, 'Customary'),
	(2, 'Important'),
	(3, 'Very Important'),
	(4, 'Arhi Important');
/*!40000 ALTER TABLE `priority` ENABLE KEYS */;


# Dumping structure for table portal.projecthistory
CREATE TABLE IF NOT EXISTS `projecthistory` (
  `id_pr_history` int(11) NOT NULL AUTO_INCREMENT,
  `id_project` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `stage` varchar(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id_pr_history`),
  KEY `id_project` (`id_project`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `projecthistory_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id_project`),
  CONSTRAINT `projecthistory_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table portal.projecthistory: ~1 rows (approximately)
/*!40000 ALTER TABLE `projecthistory` DISABLE KEYS */;
INSERT INTO `projecthistory` (`id_pr_history`, `id_project`, `id_user`, `stage`, `name`) VALUES
	(1, 1, 1, 'Finished', 'Coca-cola');
/*!40000 ALTER TABLE `projecthistory` ENABLE KEYS */;


# Dumping structure for table portal.projects
CREATE TABLE IF NOT EXISTS `projects` (
  `id_project` int(11) NOT NULL AUTO_INCREMENT,
  `id_owner` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `date_of_creation` date NOT NULL,
  `date_of_closing` date DEFAULT NULL,
  `id_category` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `license` varchar(3000) DEFAULT NULL,
  `stage_of_development` varchar(100) NOT NULL,
  PRIMARY KEY (`id_project`),
  KEY `id_owner` (`id_owner`),
  KEY `id_category` (`id_category`),
  KEY `IN_PR_NAME` (`name`(2)),
  KEY `IN_ID_PR` (`id_project`),
  CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`id_owner`) REFERENCES `users` (`id_user`),
  CONSTRAINT `projects_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `categories_pr` (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table portal.projects: ~1 rows (approximately)
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` (`id_project`, `id_owner`, `name`, `description`, `date_of_creation`, `date_of_closing`, `id_category`, `version`, `license`, `stage_of_development`) VALUES
	(1, 1, 'test', 'tested project', '2011-05-01', '2011-05-02', 1, 1, NULL, 'alpha-test');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;


# Dumping structure for table portal.status
CREATE TABLE IF NOT EXISTS `status` (
  `id_stat` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_stat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

# Dumping data for table portal.status: ~3 rows (approximately)
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` (`id_stat`, `name`) VALUES
	(1, 'banned'),
	(2, 'active'),
	(3, 'not active');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;


# Dumping structure for table portal.tags
CREATE TABLE IF NOT EXISTS `tags` (
  `id_tag` int(11) NOT NULL AUTO_INCREMENT,
  `id_project` int(11) NOT NULL,
  `tag` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tag`,`id_project`),
  KEY `id_project` (`id_project`),
  CONSTRAINT `tags_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id_project`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table portal.tags: ~2 rows (approximately)
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` (`id_tag`, `id_project`, `tag`) VALUES
	(1, 1, 'tested'),
	(2, 1, 'cool');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;


# Dumping structure for table portal.technologies
CREATE TABLE IF NOT EXISTS `technologies` (
  `id_tech` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tech`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

# Dumping data for table portal.technologies: ~5 rows (approximately)
/*!40000 ALTER TABLE `technologies` DISABLE KEYS */;
INSERT INTO `technologies` (`id_tech`, `name`) VALUES
	(1, '.NET'),
	(2, 'ActiveX'),
	(3, 'JDBS'),
	(4, 'DirectX'),
	(5, 'ASP');
/*!40000 ALTER TABLE `technologies` ENABLE KEYS */;


# Dumping structure for table portal.type_edu
CREATE TABLE IF NOT EXISTS `type_edu` (
  `id_type_edu` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(75) NOT NULL,
  PRIMARY KEY (`id_type_edu`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

# Dumping data for table portal.type_edu: ~6 rows (approximately)
/*!40000 ALTER TABLE `type_edu` DISABLE KEYS */;
INSERT INTO `type_edu` (`id_type_edu`, `name`) VALUES
	(1, 'primary school'),
	(2, 'Secondary school'),
	(3, 'High school'),
	(4, 'Magistratum'),
	(5, 'Doctoratum'),
	(6, 'Evning School))');
/*!40000 ALTER TABLE `type_edu` ENABLE KEYS */;


# Dumping structure for table portal.usergroup
CREATE TABLE IF NOT EXISTS `usergroup` (
  `id_user_group` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_user_group`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

# Dumping data for table portal.usergroup: ~3 rows (approximately)
/*!40000 ALTER TABLE `usergroup` DISABLE KEYS */;
INSERT INTO `usergroup` (`id_user_group`, `name`) VALUES
	(1, 'USer'),
	(2, 'Moderator'),
	(3, 'Admin');
/*!40000 ALTER TABLE `usergroup` ENABLE KEYS */;


# Dumping structure for table portal.userhistory
CREATE TABLE IF NOT EXISTS `userhistory` (
  `id_usr_history` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `date` date NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `id_status` int(11) NOT NULL,
  `iq` int(11) DEFAULT NULL,
  `number_of_cations` int(11) NOT NULL,
  PRIMARY KEY (`id_usr_history`),
  KEY `id_user` (`id_user`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `userhistory_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `userhistory_ibfk_2` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_stat`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table portal.userhistory: ~2 rows (approximately)
/*!40000 ALTER TABLE `userhistory` DISABLE KEYS */;
INSERT INTO `userhistory` (`id_usr_history`, `id_user`, `date`, `name`, `surname`, `id_status`, `iq`, `number_of_cations`) VALUES
	(1, 1, '2011-05-28', 'Oleg', 'Panassyuk', 1, 110, 0),
	(2, 2, '2011-05-28', 'Ivan', 'Belarus', 1, 120, 1);
/*!40000 ALTER TABLE `userhistory` ENABLE KEYS */;


# Dumping structure for table portal.userpositionhistory
CREATE TABLE IF NOT EXISTS `userpositionhistory` (
  `id_usr_position_hist` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `date` date NOT NULL,
  `id_pos` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  PRIMARY KEY (`id_usr_position_hist`),
  KEY `id_user` (`id_user`),
  KEY `id_pos` (`id_pos`),
  KEY `id_project` (`id_project`),
  CONSTRAINT `userpositionhistory_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `userpositionhistory_ibfk_2` FOREIGN KEY (`id_pos`) REFERENCES `positions` (`id_pos`),
  CONSTRAINT `userpositionhistory_ibfk_3` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id_project`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table portal.userpositionhistory: ~1 rows (approximately)
/*!40000 ALTER TABLE `userpositionhistory` DISABLE KEYS */;
INSERT INTO `userpositionhistory` (`id_usr_position_hist`, `id_user`, `date`, `id_pos`, `id_project`) VALUES
	(1, 1, '2011-05-28', 3, 1);
/*!40000 ALTER TABLE `userpositionhistory` ENABLE KEYS */;


# Dumping structure for table portal.users
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `email` varchar(70) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `telephone` varchar(25) DEFAULT NULL,
  `password` varchar(350) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `skype` varchar(70) DEFAULT NULL,
  `isq` varchar(70) DEFAULT NULL,
  `IQ` int(11) DEFAULT NULL,
  `id_stat` int(11) NOT NULL,
  `picture` blob,
  `date_of_last_visit` date NOT NULL,
  `number_of_cautions` smallint(6) DEFAULT NULL,
  `id_user_group` int(11) NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `IN_ID_USER` (`id_user`),
  KEY `IN_NAME_USER` (`name`(2)),
  KEY `IN_SURNAME_USER` (`surname`(2)),
  KEY `id_stat` (`id_stat`),
  KEY `id_user_group` (`id_user_group`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_stat`) REFERENCES `status` (`id_stat`),
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`id_user_group`) REFERENCES `usergroup` (`id_user_group`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

# Dumping data for table portal.users: ~4 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id_user`, `name`, `surname`, `email`, `date_of_birth`, `telephone`, `password`, `sex`, `skype`, `isq`, `IQ`, `id_stat`, `picture`, `date_of_last_visit`, `number_of_cautions`, `id_user_group`) VALUES
	(1, 'Oleg', 'Panasyuk', 'oleg.panasyuk@inbox.ru', '1989-08-09', '+375336426294', 'password', 1, 'oleg.panasyuk89', '409122811', 100, 1, '', '2011-05-21', 5, 3),
	(2, 'IVAN', 'RUSSIAN', 'oleg.panasyuk@inbox.ru', '1989-08-09', '+375336426294', 'password', 1, 'oleg.panasyuk89', '409122811', 100, 1, '', '2011-05-21', 5, 2),
	(3, 'Robyn', 'Scherbatzky', 'RobSche@inbox.ru', '1980-02-09', '+375336426294', 'password', 0, 'rob', '432122811', 100, 1, '', '2011-05-21', 5, 1),
	(4, 'Ted', 'Mozeby', 'TMOZ@inbox.ru', '1987-12-03', '+375336426294', 'password', 1, 'oleg.panasyuk89', '409122811', 100, 1, '', '2011-05-21', 5, 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
