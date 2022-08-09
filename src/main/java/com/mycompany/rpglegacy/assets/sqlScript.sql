create database if not exists RPGLegacy;

use RPGLegacy;

create table usuarios (
	id integer auto_increment not null,
    login varchar(50),
    senha varchar(30),
    primary key (id)
    );
    
create table herois (
	id integer auto_increment not null,
    personName varchar(50),
    atak integer,
    defe integer,
    sped integer,
    vidaMaxima integer,
    vidaAtual integer,
    expNxtLvel integer,
    lvel integer,
    progress varchar(50),
    id_usuario integer,
    primary key(id),
    foreign key(id_usuario)
		references usuarios(id)
	);
    
create table inimigos (
	id integer auto_increment not null,
    tipo varchar(70),
    personName varchar(50),
    atak integer not null,
    defe integer not null,
    sped integer not null,
    vidaMaxima integer not null,
    vidaAtual integer not null,
    lvel integer not null,
    expGanho integer not null,
    primary key(id)
    );

select * from herois;
select * from inimigos;
select * from usuarios;