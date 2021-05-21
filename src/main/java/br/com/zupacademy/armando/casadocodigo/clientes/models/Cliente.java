package br.com.zupacademy.armando.casadocodigo.clientes.models;

import br.com.zupacademy.armando.casadocodigo.core.validations.CPFOrCNPJ;
import br.com.zupacademy.armando.casadocodigo.estados.models.Estado;
import br.com.zupacademy.armando.casadocodigo.paises.models.Pais;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email @NotBlank
    @Column(nullable = false) private String email;
    @NotBlank
    @Column(nullable = false) private String nome;
    @NotBlank
    @Column(nullable = false) private String sobrenome;
    @NotBlank @CPFOrCNPJ
    @Column(nullable = false) private String documento;
    @NotBlank
    @Column(nullable = false) private String endereco;
    @NotBlank
    @Column(nullable = false) private String complemento;
    @NotBlank
    @Column(nullable = false) private String cidade;
    @NotNull
    @ManyToOne @JoinColumn(name = "pais_id", nullable = false) private Pais pais;
    @ManyToOne @JoinColumn(name = "estado_id", nullable = true) private Estado estado;
    @NotBlank
    @Column(nullable = false) private String telefone;
    @NotBlank
    @Column(nullable = false) private String cep;

    @Deprecated
    public Cliente() {
    }

    public Cliente(String email,
                   String nome,
                   String sobrenome,
                   String documento,
                   String endereco,
                   String complemento,
                   String cidade,
                   Pais pais,
                   String telefone,
                   String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
