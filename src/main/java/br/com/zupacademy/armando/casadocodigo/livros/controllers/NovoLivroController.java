package br.com.zupacademy.armando.casadocodigo.livros.controllers;

import br.com.zupacademy.armando.casadocodigo.livros.forms.NovoLivroForm;
import br.com.zupacademy.armando.casadocodigo.livros.models.Livro;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovoLivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/livros")
    @Transactional
    public void cadastrar(@RequestBody @Valid NovoLivroForm novoLivroForm) {
        Livro novoLivro = novoLivroForm.toModel(entityManager);
        entityManager.persist(novoLivro);
    }

}
