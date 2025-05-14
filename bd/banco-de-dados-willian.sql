/*-------------criando database e tabela--------------*/
create database ProjetoJava;
use ProjetoJava;
create table usuarios(id int auto_increment primary key not null,nome varchar(25) , email varchar(50) not null, senha varchar(50) not null);

select * from usuarios;
drop table usuarios;