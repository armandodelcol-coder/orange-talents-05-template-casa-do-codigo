package br.com.zupacademy.armando.casadocodigo.clientes.forms;

import br.com.zupacademy.armando.casadocodigo.clientes.models.Cliente;
import br.com.zupacademy.armando.casadocodigo.core.validations.CPFOrCNPJ;
import br.com.zupacademy.armando.casadocodigo.core.validations.ExistsId;
import br.com.zupacademy.armando.casadocodigo.core.validations.UniqueValue;
import br.com.zupacademy.armando.casadocodigo.estados.models.Estado;
import br.com.zupacademy.armando.casadocodigo.paises.models.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoClienteForm {

    @Email @NotBlank @UniqueValue(entity = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @CPFOrCNPJ @UniqueValue(entity = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull @ExistsId(entity = Pais.class)
    private Long paisId;
    @ExistsId(entity = Estado.class)
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public NovoClienteForm(String email,
                           String nome,
                           String sobrenome,
                           String documento,
                           String endereco,
                           String complemento,
                           String cidade,
                           Long paisId,
                           Long estadoId,
                           String telefone,
                           String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Cliente toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, paisId);
        Cliente cliente = new Cliente(
                email,
                nome,
                sobrenome,
                documento,
                endereco,
                complemento,
                cidade,
                pais,
                telefone,
                cep
        );
        if (estadoId != null) {
            Estado estado = entityManager.find(Estado.class, estadoId);
            cliente.setEstado(estado);
        }
        return cliente;
    }
}
