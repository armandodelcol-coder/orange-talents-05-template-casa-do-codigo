package br.com.zupacademy.armando.casadocodigo.livros.reponsedtos;

import br.com.zupacademy.armando.casadocodigo.livros.models.Livro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DetalhesLivroDto {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private String isbn;
    private LocalDateTime dataPublicacao;
    private AutorResumidoDto autor;

    public DetalhesLivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new AutorResumidoDto(livro.getAutor());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorResumidoDto getAutor() {
        return autor;
    }

}
