package br.com.zupacademy.armando.casadocodigo.autores.controllers;

import br.com.zupacademy.armando.casadocodigo.autores.forms.NovoAutorForm;
import br.com.zupacademy.armando.casadocodigo.autores.models.Autor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovoAutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/autores")
    @Transactional
    public void cadastrar(@RequestBody @Valid NovoAutorForm novoAutorForm) {
        Autor novoAutor = novoAutorForm.toModel();
        entityManager.persist(novoAutor);
    }

}
