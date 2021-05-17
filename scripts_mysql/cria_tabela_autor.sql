create table tb_autor(
    id bigint primary key auto_increment,
    email varchar(255) not null,
    nome varchar(255) not null,
    descricao text not null,
    data_criacao datetime not null
) engine=InnoDB default charset=utf8mb4;