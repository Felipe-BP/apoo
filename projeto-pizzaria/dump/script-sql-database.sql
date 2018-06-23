-- create database pizzaria;

-- use pizzaria;

create table cliente(
	cli_codigo int auto_increment,
	cli_nome varchar(50) not null,
    cli_cpf char(11) unique not null,
    cli_telefone varchar(11),
    cli_status boolean default true,
    primary key(cli_codigo)
);

create table mesa(
	mesa_codigo char(2),
    mesa_quantidade int(2),
    mesa_situacao int,
    mesa_status boolean default true,
	primary key(mesa_codigo)
);

create table reserva (
	cli_codigo int,
    mesa_codigo char(2),
    res_data datetime,
    res_status int,
    primary key(cli_codigo, mesa_codigo),
    foreign key(cli_codigo) references cliente(cli_codigo),
    foreign key(mesa_codigo) references mesa(mesa_codigo)
);

create table pedido (
	ped_codigo int auto_increment,
    mesa_codigo char(2),
    ped_total double(6, 2) default 0,
    ped_status int,
    primary key(ped_codigo, mesa_codigo),
    foreign key(mesa_codigo) references mesa(mesa_codigo)
);

create table produto (
	pro_codigo varchar(30) not null,
    pro_nome varchar(20) not null,
    pro_descricao varchar(40),
    pro_preco double(5, 2),
    pro_categoria int,
    pro_status boolean default true,
    primary key(pro_codigo)
);

create table item (
	ped_codigo int,
    pro_codigo int,
	quantidade int,
    primary key(ped_codigo, pro_codigo),
    foreign key(ped_codigo) references pedido(ped_codigo),
    foreign key(pro_codigo) references produto(pro_codigo)
);