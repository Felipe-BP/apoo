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

-- populando a tabela de mesa com as mesas existentes
insert into mesa (mesa_codigo) values ('M1');
insert into mesa (mesa_codigo) values ('M2');
insert into mesa (mesa_codigo) values ('M3');
insert into mesa (mesa_codigo) values ('M4');
insert into mesa (mesa_codigo) values ('M5');
insert into mesa (mesa_codigo) values ('M6');
insert into mesa (mesa_codigo) values ('M7');
insert into mesa (mesa_codigo) values ('M8');
insert into mesa (mesa_codigo) values ('M9');
insert into mesa (mesa_codigo) values ('MA');
insert into mesa (mesa_codigo) values ('MB');
insert into mesa (mesa_codigo) values ('MC');

-- popula a tabela de produtos com os produtos disponíveis
insert into produto (pro_codigo, pro_nome, pro_descricao, pro_preco, pro_categoria) values ('P001', 'Pizza', 'PizzaTGrande', 48.00, 'Comida');
insert into produto (pro_codigo, pro_nome, pro_descricao, pro_preco, pro_categoria) values ('P002', 'Pizza', 'PizzaTGrandeDoce', 45.00, 'Comida');
insert into produto (pro_codigo, pro_nome, pro_descricao, pro_preco, pro_categoria) values ('P003', 'Salgado', 'Salgado Assado', 12.00, 'Comida');
insert into produto (pro_codigo, pro_nome, pro_descricao, pro_preco, pro_categoria) values ('P004', 'Coca-Cola', 'Refrigerante Coca 2L', 15.00, 'Bebida');
insert into produto (pro_codigo, pro_nome, pro_descricao, pro_preco, pro_categoria) values ('P005', 'Coca-Cola', 'Refrigerante Coca lata', 6.00, 'Bebida');
insert into produto (pro_codigo, pro_nome, pro_descricao, pro_preco, pro_categoria) values ('P006', 'Guaraná', ' =Refrigerante Guaraná lata', 6.00, 'Bebida');