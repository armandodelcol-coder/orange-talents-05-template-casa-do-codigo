package br.com.zupacademy.armando.casadocodigo.estados.forms;

import br.com.zupacademy.armando.casadocodigo.core.validations.ExistsId;
import br.com.zupacademy.armando.casadocodigo.estados.models.Estado;
import br.com.zupacademy.armando.casadocodigo.paises.models.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoForm {

    @NotBlank
    private String nome;
    @NotNull @ExistsId(entity = Pais.class)
    private Long paisId;

    public NovoEstadoForm(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, paisId);
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

}
