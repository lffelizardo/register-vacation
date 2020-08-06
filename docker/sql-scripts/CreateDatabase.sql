CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(300) NOT NULL,
  `name` varchar(300) NOT NULL,
  `password` varchar(300) NOT NULL,
  `username` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(300) DEFAULT NULL,
  `complement` varchar(300) DEFAULT NULL,
  `contract_date` date NOT NULL,
  `date_of_birth` date NOT NULL,
  `image_url` varchar(300) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `neighborhood` varchar(300) DEFAULT NULL,
  `number` varchar(300) DEFAULT NULL,
  `registration` varchar(300) DEFAULT NULL,
  `state` varchar(300) DEFAULT NULL,
  `street` varchar(300) DEFAULT NULL,
  `team_id` int(11) NOT NULL,
  `email` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bbhw2v3bm2hrur4fjh5tf1aj6` (`registration`),
  KEY `FK8d7lrsr6kwirr93rx0tafnoqa` (`team_id`),
  CONSTRAINT `FK8d7lrsr6kwirr93rx0tafnoqa` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `vacation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `finish_date` date NOT NULL,
  `start_date` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6qrwq18c5kq468gvsmwm43cgp` (`employee_id`),
  CONSTRAINT `FK6qrwq18c5kq468gvsmwm43cgp` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

use register;

INSERT INTO users (id,email,name,password,username) VALUES (1,'lonny@test.com','Tavares MacGyver','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','lonny');
INSERT INTO users (id,email,name,password,username) VALUES (2,'sherman@test.com','Annabel Erdman','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','sherman');
INSERT INTO users (id,email,name,password,username) VALUES (3,'tobin@test.com','Dr. Jazlyn Fisher','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','tobin');
INSERT INTO users (id,email,name,password,username) VALUES (4,'cleve@test.com','Daniella Simonis I','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','cleve');
INSERT INTO users (id,email,name,password,username) VALUES (5,'alverta@test.com','Kayden Leuschke','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','alverta');
INSERT INTO users (id,email,name,password,username) VALUES (6,'brody@test.com','Esteban Cruickshank I','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','brody');
INSERT INTO users (id,email,name,password,username) VALUES (7,'junius@test.com','Stephanie King DDS','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','junius');
INSERT INTO users (id,email,name,password,username) VALUES (8,'stacy@test.com','Giovanna Maggio','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','stacy');
INSERT INTO users (id,email,name,password,username) VALUES (9,'wyatt@test.com','Ms. Leanna Wintheiser','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','wyatt');
INSERT INTO users (id,email,name,password,username) VALUES (10,'chance@test.com','Dessie Stiedemann','$2a$10$EiOxJOFXe0qqHg0zVL6vGOnW2yeQtJpOiqulX7sHXXKxFC1fFRndG','chance');

INSERT INTO team (id,name) VALUES (1,'Tropa de Elite');
INSERT INTO team (id,name) VALUES (2,'Shield');
INSERT INTO team (id,name) VALUES (3,'Jedi');
INSERT INTO team (id,name) VALUES (4,'Builder');

INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (1,'Leramouth','house','2014-04-18','1978-03-09',NULL,'Stone Harris','NULL','439','7a78c842-b8b2-43cf-90e9-1ada8c2bf2af','North Carolina','810 Horacio Shore',3,'janis@test.com');
INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (2,'Johnsberg','house','2015-10-07','1993-05-03',NULL,'Mrs. Cordia Von','NULL','293','ddf81461-98c6-4075-b78a-ed359b8ba43c','Nevada','72861 Hegmann Fork',2,'reymundo@test.com');
INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (3,'Harrisberg','house','2018-03-05','1984-01-28',NULL,'Karli Tillman','NULL','30','ebc6ece3-2afe-4e2d-a362-21343c7397bd','Nebraska','95151 King Lock',4,'jena@test.com');
INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (4,'Krisville','house','2015-05-09','1981-09-28',NULL,'Winnifred Berge','NULL','144','0e9895ea-c908-49cb-a5f5-76472c1d1bb5','Alabama','0913 Baumbach Avenue',1,'lorena@test.com');
INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (5,'Shanyport','house','2009-06-21','1977-07-09',NULL,'Jessyca Keeling Sr.','NULL','424','ad47312e-2836-42d2-a6d4-e4faf1053bb1','Minnesota','62862 Carter Trail',1,'mason@test.com');
INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (6,'Taniaberg','house','2011-01-26','1992-05-26',NULL,'Ms. Brisa Hodkiewicz','NULL','344','39c3fec0-600b-4ba6-8dff-f0b3633d8a7e','Alaska','048 Dayana Pine',1,'schuyler@test.com');
INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (7,'Stehrstad','house','2018-12-02','1992-10-06',NULL,'Dr. Lesley Huels','NULL','814','d8e36d04-92d4-4c14-9836-d7380e6bb388','Delaware','26862 Conroy Mission',3,'jordi@test.com');
INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (8,'Port Zelma','house','2013-11-10','1999-07-06',NULL,'Hester Sipes','NULL','331','b214005c-d521-4d5f-a699-1bdb3a6fcb23','Massachusetts','209 Roma Overpass',2,'mazie@test.com');
INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (9,'Port Anna','house','2010-11-13','1996-02-24',NULL,'Ms. Jadon Carter','NULL','393','ffac3228-7012-4f41-bba9-5798f8f9f8ce','New Hampshire','71131 Angelica Mission',2,'wilmer@test.com');
INSERT INTO employee (id,city,complement,contract_date,date_of_birth,image_url,name,neighborhood,number,registration,state,street,team_id,email) VALUES (10,'South Kelvin','house','2018-09-24','1987-08-04',NULL,'Santino Spinka','NULL','319','e2ba3d47-431e-4f38-9867-8684e61c5ea8','Virginia','14766 Batz Camp',4,'howell@test.com');

INSERT INTO vacation (id,finish_date,start_date,employee_id) VALUES (1,'2020-06-30','2020-06-15',1);