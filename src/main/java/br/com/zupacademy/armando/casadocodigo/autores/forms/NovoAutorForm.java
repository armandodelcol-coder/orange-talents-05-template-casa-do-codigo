package br.com.zupacademy.armando.casadocodigo.autores.forms;

import br.com.zupacademy.armando.casadocodigo.autores.models.Autor;
import br.com.zupacademy.armando.casadocodigo.core.validations.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoAutorForm {

    @NotBlank @Email @UniqueValue(entity = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank @Length(max = 400)
    private String descricao;

    public NovoAutorForm(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.email, this.nome, this.descricao);
    }
}
