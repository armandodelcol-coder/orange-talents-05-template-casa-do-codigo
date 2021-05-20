package br.com.zupacademy.armando.casadocodigo.paises.controllers;

import br.com.zupacademy.armando.casadocodigo.paises.forms.NovoPaisForm;
import br.com.zupacademy.armando.casadocodigo.paises.models.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovoPaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/paises")
    @Transactional
    public void cadastrar(@RequestBody @Valid NovoPaisForm novoPaisForm) {
        Pais novoPais = novoPaisForm.toModel();
        entityManager.persist(novoPais);
    }

}
