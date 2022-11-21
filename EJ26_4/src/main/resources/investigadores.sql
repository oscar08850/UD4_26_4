DROP DATABASE IF EXISTS investigadores;
CREATE DATABASE investigadores;
USE investigadores;

DROP TABLE IF EXISTS facultad;
CREATE TABLE facultad(
codigo int AUTO_INCREMENT PRIMARY KEY,
nombre varchar(100)
);

INSERT INTO facultad(nombre) VALUE ('facultad 1');
INSERT INTO facultad(nombre) VALUE ('facultad 2');
INSERT INTO facultad(nombre) VALUE ('facultad 3');

DROP TABLE IF EXISTS investigadores;
CREATE TABLE investigadores(
dni varchar(8) PRIMARY KEY,
nomapels varchar(255),
facultad int,
FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE SET NULL ON UPDATE CASCADE
);

INSERT INTO investigadores(dni,nomapels,facultad) VALUE ('1111111A','Investigador1',1);
INSERT INTO investigadores(dni,nomapels,facultad) VALUE ('1111111B','Investigador2',2);
INSERT INTO investigadores(dni,nomapels,facultad) VALUE ('1111111C','Investigador3',3);

DROP TABLE IF EXISTS equipos;
CREATE TABLE equipos(
numserie char(4) PRIMARY KEY,
nombre varchar(100),
facultad int,
FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE SET NULL ON UPDATE CASCADE
);

INSERT INTO equipos(numserie,nombre,facultad) VALUE ('111A','Equipo1',1);
INSERT INTO equipos(numserie,nombre,facultad) VALUE ('222B','Equipo2',2);
INSERT INTO equipos(numserie,nombre,facultad) VALUE ('333C','Equipo3',3);

DROP TABLE IF EXISTS reserva;
CREATE TABLE reserva(
id int AUTO_INCREMENT PRIMARY KEY,
dni varchar(8),
numserie char(4),
comienzo date,
fin date,
FOREIGN KEY (dni) REFERENCES investigadores(dni) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (numserie) REFERENCES equipos(numserie) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO reserva(dni,numserie,comienzo,fin) VALUE ('1111111A','111A','2010-05-07','2010-07-05');
INSERT INTO reserva(dni,numserie,comienzo,fin) VALUE ('1111111B','222B','2010-11-08','2010-08-11');
INSERT INTO reserva(dni,numserie,comienzo,fin) VALUE ('1111111C','333C','2010-06-11','2010-11-06');
