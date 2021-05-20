create table tb_pais(
    id bigint primary key auto_increment,
    nome varchar(255) not null unique
) engine=InnoDB default charset=utf8mb4;