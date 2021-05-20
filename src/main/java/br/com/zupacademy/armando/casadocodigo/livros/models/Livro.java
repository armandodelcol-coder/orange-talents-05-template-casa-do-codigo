package br.com.zupacademy.armando.casadocodigo.livros.models;

import br.com.zupacademy.armando.casadocodigo.autores.models.Autor;
import br.com.zupacademy.armando.casadocodigo.categorias.models.Categoria;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String titulo;
    @NotBlank @Length(max = 500)
    @Column(columnDefinition = "text", nullable = false)
    private String resumo;
    @NotBlank
    @Column(columnDefinition = "text", nullable = false)
    private String sumario;
    @NotNull @Min(20)
    @Column(columnDefinition = "decimal", nullable = false)
    private BigDecimal preco;
    @NotNull @Min(100)
    @Column(columnDefinition = "smallint unsigned", nullable = false)
    private Integer paginas;
    @NotBlank @ISBN(type = ISBN.Type.ANY)
    @Column(nullable = false, unique = true)
    private String isbn;
    @NotNull @Future
    @Column(columnDefinition = "datetime", nullable = false)
    private LocalDateTime dataPublicacao;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(String titulo,
                 String resumo,
                 String sumario,
                 BigDecimal preco,
                 Integer paginas,
                 String isbn,
                 LocalDateTime dataPublicacao,
                 Categoria categoria,
                 Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
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

    public Autor getAutor() {
        return autor;
    }

}
