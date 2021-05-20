package br.com.zupacademy.armando.casadocodigo.estados.controllers;

import br.com.zupacademy.armando.casadocodigo.estados.validations.StateDuplicateInCountryValidator;
import br.com.zupacademy.armando.casadocodigo.estados.forms.NovoEstadoForm;
import br.com.zupacademy.armando.casadocodigo.estados.models.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovoEstadoController {

    @Autowired
    private StateDuplicateInCountryValidator stateDuplicateInCountryValidator;

    @PersistenceContext
    private EntityManager entityManager;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(stateDuplicateInCountryValidator);
    }

    @PostMapping("/estados")
    @Transactional
    public void cadastrar(@RequestBody @Valid NovoEstadoForm novoEstadoForm) {
        Estado novoEstado = novoEstadoForm.toModel(entityManager);
        entityManager.persist(novoEstado);
    }

}
