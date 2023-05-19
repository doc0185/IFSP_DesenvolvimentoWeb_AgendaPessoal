create database agendaPessoal;
use agendaPessoal;
create table usuarios (
	id int not null auto_increment,
    login varchar(30) not null,
    senha varchar(30) not null,
    nome varchar(30) not null,
    email varchar(30) not null,
    primary key(id)
);

create table tarefas (
	id int not null auto_increment,
    user_id int not null,
    descricao varchar(30) not null,
    data_criacao date,
    data_conclusao date,
    stat varchar(30),
    primary key (id),
    foreign key(user_id) references usuarios(id)
);