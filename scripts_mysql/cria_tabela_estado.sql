create table tb_estado(
    id bigint primary key auto_increment,
    nome varchar(255) not null unique,
    pais_id bigint not null,

    constraint fk_estado_pais foreign key(pais_id) references tb_pais(id)
) engine=InnoDB default charset=utf8mb4;