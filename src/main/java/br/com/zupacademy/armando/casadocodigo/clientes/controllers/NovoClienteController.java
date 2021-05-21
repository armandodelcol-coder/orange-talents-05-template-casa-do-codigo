package br.com.zupacademy.armando.casadocodigo.clientes.controllers;

import br.com.zupacademy.armando.casadocodigo.clientes.forms.NovoClienteForm;
import br.com.zupacademy.armando.casadocodigo.clientes.models.Cliente;
import br.com.zupacademy.armando.casadocodigo.clientes.responsedtos.ClienteCadastradoDto;
import br.com.zupacademy.armando.casadocodigo.clientes.validations.StateExistsInCountryValidator;
import br.com.zupacademy.armando.casadocodigo.clientes.validations.StateNotNullValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class NovoClienteController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StateExistsInCountryValidator stateExistsInCountryValidator;

    @Autowired
    private StateNotNullValidator stateNotNullValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(stateExistsInCountryValidator);
        webDataBinder.addValidators(stateNotNullValidator);
    }

    @PostMapping("/clientes")
    @Transactional
    public ResponseEntity<ClienteCadastradoDto> cadastrar(@RequestBody @Valid NovoClienteForm novoClienteForm) {
        Cliente novoCliente = novoClienteForm.toModel(entityManager);
        entityManager.persist(novoCliente);
        return ResponseEntity.ok(new ClienteCadastradoDto(novoCliente));
    }

}
