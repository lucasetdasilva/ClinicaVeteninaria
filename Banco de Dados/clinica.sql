create database Clinica;
use Clinica;

create table Veteninario(
cpf varchar(14) primary key not null,
nome varchar(40) not null,
telefone bigint not null,
email varchar(30) not null,
senha text not null
);

create table Responsavel(
cpf varchar(14) primary key not null,
nome varchar(40) not null,
telefone bigint not null,
data_nascimento date not null,
email varchar(30) not null,
senha text not null
);

create table Remedio(
id int auto_increment primary key not null,
nome varchar(20) not null
);

create table Especie(
nome varchar(20) primary key not null,
descricao text null
);

create table Animal(
id int auto_increment primary key not null,
nome varchar(30) not null,
raca varchar(30) not null,
data_nascimento date not null,
fk_cpf varchar(14) not null,
fk_especie varchar(20) not null,
foreign key (fk_cpf) references Responsavel(cpf), 
foreign key (fk_especie) references Especie(nome)
);

create table Receita(
fk_id_animal int not null,
fk_id_remedio int not null,
dosagem varchar(15) not null,
intervalo_tempo varchar(15) not null,
duracao varchar(10) not null,
primary key (fk_id_animal, fk_id_remedio),
foreign key (fk_id_animal) references Animal(id),
foreign key (fk_id_remedio) references Remedio(id)
);

create table Administrador(
cpf varchar(14) primary key not null,
nome varchar(20) not null,
email varchar(40) not null,
senha text not null  
);

create table Consulta(
fk_cpf varchar(14) not null,
fk_id_animal int not null,
data_horario datetime not null,
descricao text not null,
primary key(fk_cpf,fk_id_animal),
foreign key (fk_cpf) references Veteninario(cpf),
foreign key (fk_id_animal) references Animal(id) 
);

create table Vacina(
id_vacina varchar(30) primary key not null,
nome_vacina varchar(30) not null
);

create table Caderneta(
fk_id_vacina varchar(30) not null,
fk_animal int not null,
primary key(fk_id_vacina,fk_animal),
foreign key (fk_id_vacina) references Vacina(id_vacina),
foreign key (fk_animal) references Animal(id) 
);
