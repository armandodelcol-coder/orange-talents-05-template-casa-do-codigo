package br.com.zupacademy.armando.casadocodigo.livros.reponsedtos;

import br.com.zupacademy.armando.casadocodigo.livros.models.Livro;

public class LivrosListaDto {

    private Long id;
    private String nome;

    public LivrosListaDto(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
