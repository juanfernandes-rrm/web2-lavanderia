create table endereco(
	id serial primary key,
	estado varchar(100),
	cidade varchar(150),
	bairro varchar(150),
	rua varchar(150),
	numero varchar(100)
);

create table usuario(
	id serial primary key,
	cpf varchar(11) not null unique,
	nome varchar(100) not null,
	email varchar(100) not null unique,
	endereco_fk bigint,
	telefone varchar(15),
	senha varchar(150),
	foreign key (endereco_fk) references endereco(id)
);

create table pedido(
	numero serial primary key,
	prazo date,
	valor_total real,
	status_pedido varchar(100),
	data_criacao timestamp,
	cliente_fk bigint,
	foreign key (cliente_fk) references usuario(id)
);

create table roupa(
	id serial primary key,
	peca varchar(100),
	valor real,
	prazo_entrega integer
);

create table roupa_pedido(
	pedido_fk bigint,
	roupa_fk bigint,
	qtd_peca integer,
	foreign key (pedido_fk) references pedido(numero),
	foreign key (roupa_fk) references roupa(id),
	primary key(pedido_fk, roupa_fk)
);

-- SCRIPTS DE INSERÇÃO PARA APRESENTAÇÃO --
--INSERT INTO endereco(estado, cidade, bairro, rua, numero) VALUES ('Paraná','Curitiba','Jardim das Américas','R. Dr. Alcides Vieira Arcoverde', '1225');
--INSERT INTO usuario(cpf, nome, email, endereco_fk, telefone, senha) VALUES('00000000001','cliente','cliente@email.com', 1, '00 99999-9999','cliente');
--INSERT INTO usuario(cpf, nome, email, endereco_fk, telefone, senha) VALUES('00000000002','funcionario','funcionario@email.com', 1, '00 99999-9999','funcionario');
