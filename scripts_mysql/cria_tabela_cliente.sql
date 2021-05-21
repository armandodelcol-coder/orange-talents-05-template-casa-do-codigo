create table tb_cliente(
    id bigint primary key auto_increment,
    email varchar(255) not null unique,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    documento varchar(255) not null unique,
    endereco varchar(255) not null,
    complemento varchar(255) not null,
    cidade varchar(255) not null,
    pais_id bigint not null,
    estado_id bigint,
    telefone varchar(255) not null,
    cep varchar(255) not null,

    constraint fk_cliente_pais foreign key(pais_id) references tb_pais(id),
    constraint fk_cliente_estado foreign key(estado_id) references tb_estado(id)
) engine=InnoDB default charset=utf8mb4;