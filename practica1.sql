CREATE TABLE usuario (
nombre varchar(25) NOT NULL,
apellido varchar(25) NOT NULL,
username varchar(25) PRIMARY KEY,
password varchar(25) NOT NULL,
email varchar(25) NOT NULL
);

CREATE TABLE estudiante (
username varchar(25) references usuario(username),
materia varchar(30) NOT NULL,
escolaridad varchar(30) NOT NULL
);