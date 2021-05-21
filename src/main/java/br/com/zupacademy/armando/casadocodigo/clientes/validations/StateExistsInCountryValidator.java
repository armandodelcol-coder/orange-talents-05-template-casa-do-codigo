package br.com.zupacademy.armando.casadocodigo.clientes.validations;

import br.com.zupacademy.armando.casadocodigo.clientes.forms.NovoClienteForm;
import br.com.zupacademy.armando.casadocodigo.estados.models.Estado;
import br.com.zupacademy.armando.casadocodigo.paises.models.Pais;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class StateExistsInCountryValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(NovoClienteForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoClienteForm novoClienteForm = (NovoClienteForm) target;
        Long estadoId = novoClienteForm.getEstadoId();
        Long paisId = novoClienteForm.getPaisId();
        if (errors.hasErrors() || estadoId == null) return;

        Estado estado = entityManager.find(Estado.class, estadoId);
        Pais pais = entityManager.find(Pais.class, paisId);
        Assert.state(estado != null, "O estado não pode ser nulo dentro do validador StateExistsInCountryValidator.");

        if (estado.pertenceAoPais(pais)) return;

        errors.rejectValue("estadoId", "StateExistsInCountry", "Estado não pertence ao país informado.");
    }

}
