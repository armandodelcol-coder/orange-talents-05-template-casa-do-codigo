create table tb_livro(
    id bigint primary key auto_increment,
    titulo varchar(255) not null unique,
    resumo text not null,
    sumario text not null,
    preco decimal(10,2) not null,
    paginas smallint unsigned not null,
    isbn varchar(255) unique not null,
    data_publicacao datetime not null,
    categoria_id bigint not null,
    autor_id bigint not null,

    constraint fk_livro_categoria foreign key(categoria_id) references tb_categoria(id),
    constraint fk_autor_categoria foreign key(autor_id) references tb_autor(id)
) engine=InnoDB default charset=utf8mb4;