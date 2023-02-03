create table endereco(
	id serial primary key,
	cidade varchar(150),
	estado varchar(100)
);

create table users(
	id serial primary key,
	cpf varchar(11) not null,
	nome varchar(100) not null,
	email varchar(100) not null,
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
	data_criacao timestamp
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
