/*
 * Host: db-tp.cpe.fr 
 * login, pass, schéma: binome36 
 */

CREATE TABLE IF NOT EXISTS USERS (
	id int auto_increment not null,
	lastName varchar(255),
	firstName varchar(255),
	login varchar(255),
	password varchar(255),
	email varchar(255),
	birthdate date,
	administrator boolean,
	CONSTRAINT PK_USERS PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS RECEIPE (
	id int auto_increment not null,
	name varchar(255),
	resume varchar(300),
	details varchar(1000),
	nbPersons int,
	complexity int,
	type varchar(30),
	CONSTRAINT PK_RECEIPE PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS NOTE (
	id int auto_increment not null,
	idReceipe Integer not null,
	title varchar(30),
	note varchar(300),
	CONSTRAINT PK_NOTE PRIMARY KEY (id)
);

ALTER TABLE NOTE
ADD FOREIGN KEY (idReceipe) REFERENCES RECEIPE(id); 

ALTER TABLE NOTE
ADD idUser int not null;


