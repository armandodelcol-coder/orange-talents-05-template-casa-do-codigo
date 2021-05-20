package br.com.zupacademy.armando.casadocodigo.paises.forms;

import br.com.zupacademy.armando.casadocodigo.core.validations.UniqueValue;
import br.com.zupacademy.armando.casadocodigo.paises.models.Pais;

import javax.validation.constraints.NotBlank;

public class NovoPaisForm {

    @NotBlank @UniqueValue(entity = Pais.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }

}
