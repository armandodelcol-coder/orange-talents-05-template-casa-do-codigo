package br.com.zupacademy.armando.casadocodigo.categorias.forms;

import br.com.zupacademy.armando.casadocodigo.categorias.models.Categoria;
import br.com.zupacademy.armando.casadocodigo.core.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaForm {

    @NotBlank @UniqueValue(entity = Categoria.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
