package br.com.zupacademy.armando.casadocodigo.livros.reponsedtos;

import br.com.zupacademy.armando.casadocodigo.autores.models.Autor;

public class AutorResumidoDto {

    private String nome;
    private String descricao;

    public AutorResumidoDto(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
