package br.com.zupacademy.armando.casadocodigo.autores.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_autor")
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Email
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Column(nullable = false)
    private String nome;
    @NotBlank @Length(max = 400)
    @Column(columnDefinition = "text", nullable = false)
    private String descricao;
    @CreationTimestamp
    @Column(columnDefinition = "datetime", nullable = false)
    private LocalDateTime dataCriacao;

    @Deprecated
    public Autor() {
    }

    public Autor(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

}
