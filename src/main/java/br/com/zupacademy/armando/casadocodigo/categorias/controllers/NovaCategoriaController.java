package br.com.zupacademy.armando.casadocodigo.categorias.controllers;

import br.com.zupacademy.armando.casadocodigo.categorias.forms.NovaCategoriaForm;
import br.com.zupacademy.armando.casadocodigo.categorias.models.Categoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovaCategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/categorias")
    @Transactional
    public void cadastrar(@RequestBody @Valid NovaCategoriaForm novaCategoriaForm) {
        Categoria novaCategoria = novaCategoriaForm.toModel();
        entityManager.persist(novaCategoria);
    }

}
