package br.com.zupacademy.armando.casadocodigo.livros.forms;

import br.com.zupacademy.armando.casadocodigo.autores.models.Autor;
import br.com.zupacademy.armando.casadocodigo.categorias.models.Categoria;
import br.com.zupacademy.armando.casadocodigo.core.validations.ExistsId;
import br.com.zupacademy.armando.casadocodigo.core.validations.FutureLocalDateTime;
import br.com.zupacademy.armando.casadocodigo.core.validations.UniqueValue;
import br.com.zupacademy.armando.casadocodigo.livros.models.Livro;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EntityManager;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NovoLivroForm {

    private static final String PADRAO_LOCALDATETIME = "dd/MM/yyyy HH:mm:ss";

    @NotBlank @UniqueValue(entity = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank @Length(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(20)
    private BigDecimal preco;
    @NotNull @Min(100)
    private Integer paginas;
    @NotBlank @ISBN(type = ISBN.Type.ANY) @UniqueValue(entity = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotBlank @FutureLocalDateTime(pattern = PADRAO_LOCALDATETIME)
    private String dataPublicacao;
    @NotNull @ExistsId(entity = Categoria.class)
    private Long categoriaId;
    @NotNull @ExistsId(entity = Autor.class)
    private Long autorId;

    public NovoLivroForm(String titulo,
                         String resumo,
                         String sumario,
                         BigDecimal preco,
                         Integer paginas,
                         String isbn,
                         String dataPublicacao,
                         Long categoriaId,
                         Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public Livro toModel(EntityManager entityManager) {
        Categoria categoria = entityManager.find(Categoria.class, categoriaId);
        Autor autor = entityManager.find(Autor.class, autorId);
        LocalDateTime dataPublicacao = LocalDateTime.parse(this.dataPublicacao, DateTimeFormatter.ofPattern(PADRAO_LOCALDATETIME));
        return new Livro(
                this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.paginas,
                this.isbn,
                dataPublicacao,
                categoria,
                autor
        );
    }

}
