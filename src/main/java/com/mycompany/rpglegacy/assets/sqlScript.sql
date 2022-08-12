create database if not exists RPGLegacy;

use RPGLegacy;

CREATE TABLE usuarios (
    id INTEGER AUTO_INCREMENT NOT NULL,
    login VARCHAR(50)NOT NULL UNIQUE,
    senha VARCHAR(256)NOT NULL,
    PRIMARY KEY (id)
);
    
CREATE TABLE herois (
    id INTEGER AUTO_INCREMENT NOT NULL,
    personName VARCHAR(50) NOT NULL,
    atak INTEGER NOT NULL,
    defe INTEGER NOT NULL,
    sped INTEGER NOT NULL,
    vidaMaxima INTEGER NOT NULL,
    vidaAtual INTEGER NOT NULL,
    expNxtLvel INTEGER NOT NULL,
    lvel INTEGER NOT NULL,
    progress VARCHAR(50) NOT NULL,
    id_usuario INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario)
        REFERENCES usuarios (id)
);
    
CREATE TABLE inimigos (
    id INTEGER AUTO_INCREMENT NOT NULL,
    tipo VARCHAR(70),
    personName VARCHAR(50),
    atak INTEGER NOT NULL,
    defe INTEGER NOT NULL,
    sped INTEGER NOT NULL,
    vidaMaxima INTEGER NOT NULL,
    vidaAtual INTEGER NOT NULL,
    lvel INTEGER NOT NULL,
    expGanho INTEGER NOT NULL,
    PRIMARY KEY (id)
);

select * from herois;
select * from inimigos;
select * from usuarios;