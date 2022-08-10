#COMENT PARA PUSHEAR

create schema DB_Gestion_Educativa;
use DB_Gestion_Educativa;

#TABLAS
create table carrera (
	id int primary key auto_increment not null,
    nombre nvarchar(50) not null,
    estado bit not null
);

create table materia (
	id int primary key auto_increment not null,
    nombre nvarchar(50) not null,
    estado bit not null,
    id_carrera int not null,
    foreign key (id_carrera) references carrera(id)
);

create table tipo_usuario(
	id int primary key auto_increment not null,
    nombre_tipo nvarchar(10)
);

create table usuario (
	id int primary key auto_increment not null,
    user_name nvarchar(50) not null,
    pass nvarchar(50) not null,
    tipo int not null,
    token int,
    estado bit not null,
    foreign key (tipo) references tipo_usuario(id)
);

create table docente (
	id int primary key auto_increment not null,
    legajo nvarchar(10) not null unique,
    dni nvarchar(10) not null unique,
    nombre nvarchar(15) not null,
    apellido nvarchar(15) not null,
    fecha_nac date not null,
    adress nvarchar(20) not null,
	id_pais int not null,
    id_provincia int not null,
    id_localidad int not null,
    email nvarchar(50) not null,
    tel nvarchar(20) not null,
    estado bit not null,
    foreign key (id_pais) references pais(id),
    foreign key (id_provincia) references provincia(id),
    foreign key (id_localidad) references localidad(id)
);

create table alumno (
	id int primary key auto_increment not null,
    legajo nvarchar(10) not null unique,
    dni nvarchar(10) not null unique,
    nombre nvarchar(15) not null,
    apellido nvarchar(15) not null,
    fecha_nac date not null,
    adress nvarchar(20) not null,
    id_pais int not null,
    id_provincia int not null,
    id_localidad int not null,
    email nvarchar(50) not null,
    tel nvarchar(20) not null,
    estado bit not null,
	foreign key (id_pais) references pais(id),
    foreign key (id_provincia) references provincia(id),
    foreign key (id_localidad) references localidad(id)
);

create table curso (
	id int primary key auto_increment not null,
    nombre nvarchar(15) not null,
    semestre nvarchar(20) not null,
    anio nvarchar(4) not null,
    id_docente int not null,
    id_materia int not null,
    foreign key (id_docente) references docente(id),
    foreign key (id_materia) references materia(id),
    estado bit not null
);

create table alumnos_x_curso(
	id_alumno int not null, 
    id_curso int not null,
	foreign key (id_alumno) references alumno(id),
    foreign key (id_curso) references curso(id),
    primary key(id_alumno, id_curso)
);

create table pais(
	id int primary key auto_increment not null,
    nombre nvarchar(50) not null
);

create table provincia(
	id int primary key auto_increment not null,
	nombre nvarchar(50) not null,
    id_pais int not null,
    foreign key (id_pais) references pais(id)
);

create table localidad(
	id int primary key auto_increment not null,
	nombre nvarchar(50) not null,
    id_provincia int not null,
    foreign key (id_provincia) references provincia(id)
);



create table calificacion_x_alumno(
	id int primary key auto_increment not null,
    id_alumno int not null,
    id_curso int not null,
    parcial_1 decimal(3,2),
    parcial_2 decimal(3,2),
    recuperatorio_1 decimal(3,2),
    recuperatorio_2 decimal(3,2),
    estado_academico bit not null,
    foreign key (id_alumno) references alumno(id),
    foreign key (id_curso) references curso(id)
);

#INSERTS
insert into carrera (nombre, estado) values (	"Tecnicatura Universitaria de Programacion"	,	1	);

insert into materia (nombre, estado, id_carrera) values 
	("Programacion 1"	,	1	,1),
	("Programacion 2"	,	1	,1),
	("Matematica"	,	1	,1),
	("Laboratorio 1"	,	1	,1),
	("Laboratorio 2"	,	1	,1),
	("Contabilidad"	,	1	,1),
	("Administracion de Base de Datos"	,	1	,1),
    ("Ingles"	,	1	,1),
    ("Estadistica"	,	1	,1),
    ("Organizacion Empresarial"	,	1	,1),
    ("Sistema de procesamiento de datos"	,	1	,1);


insert into pais (nombre) values ('Argentina'),('Chile'),('Uruguay');

insert into provincia (nombre, id_pais) 
value
("Buenos Aires", 1),
("Cordoba", 1),
("Santa Fe", 1),
("Santiago", 2),
("Capitan Prat", 2),
("General Carrera", 2),
("Montevideo", 3),
("Artigas", 3),
("Colonia", 3);

insert into localidad (nombre, id_provincia)
values
("General Rodriguez", 1),
("Pacheco", 1),
("Beccar", 1),
("Carlos Paz", 2),
("Villa General Belgrano", 2),
("Cordoba Capital", 2),
("Ciudad de Santa Fe", 3),
("Santo Tome", 3),
("Rafaela", 3),
("Cerrillos", 4),
("Cerro Navia", 4),
("Ciudad del Cavo", 5),
("Ciudad Oculta", 6),
("San Tomas", 7),
("Centro Artigas", 8),
("Tomas", 9);


INSERT INTO alumno (legajo, dni, nombre, apellido, fecha_nac, adress, id_pais, id_provincia, id_localidad, email, tel, estado) VALUES 
("1004","9004","Homero","Simpson","1969-04-11","Av siempre viva 743",1,2,3,"hsimpson@yahoo.com","3525153",1),
("1005","9010","March","Simpson","1975-04-12","Av siempre viva 743",2,2,3,"msimpson@yahoo.com","63262136",1),
("1006","9011","Tamara","Herrera","1980-02-09","Bilbao 653",3,2,1,"therrera@hotmail.com","2361612",1),
("1007","9012","James","Simpson","1990-03-11","Peron 1444",1,1,2,"jsimpson@yahoo.com","5235235",1),
("1008","9013","Cody","Sin","2001-04-01","Calle azul 10",1,2,3,"Csin@yahoo.com","1234245",1),
("1009","9014","Terra","Carry","2005-10-23","Block 19",1,2,8,"tcarry@yahoo.com","62626322",1),
("1010","9015","Josh","Travelta","1970-09-11","Taquiari 887",3,6,15,"jtravelta@yahoo.com","9124908",1),
("1012","9016","Master","Chief","1980-01-01","Kito 111",2,1,14,"master.f.chief@yahoo.com","128391",1),
("1013","9017","Nito","Legend","1999-01-02","Maipu 1442",1,1,1,"nlegendt@yahoo.com","92138319",1),
("1014","9018","Artorias","Sun","1969-09-12","Carlos 78",3,1,16,"asun@yahoo.com","123912",1),
("1015","9019","Dante","Smith","2001-11-11","Centenario 15666",2,7,8,"dsmith@yahoo.com","981231",1);

insert into tipo_usuario (nombre_tipo) values ("Admin"), ("Profesor");

insert into usuario (user_name, pass, tipo, token, estado) values ("admin", "admin", 1, 1, 1);



