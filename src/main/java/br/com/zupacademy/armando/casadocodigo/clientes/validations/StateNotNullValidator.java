package br.com.zupacademy.armando.casadocodigo.clientes.validations;

import br.com.zupacademy.armando.casadocodigo.clientes.forms.NovoClienteForm;
import br.com.zupacademy.armando.casadocodigo.estados.models.Estado;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class StateNotNullValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(NovoClienteForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;

        NovoClienteForm novoClienteForm = (NovoClienteForm) target;
        Long paisId = novoClienteForm.getPaisId();
        Long estadoId = novoClienteForm.getEstadoId();
        Query query = entityManager.createQuery("select e from Estado e where e.pais.id = :paisId");
        query.setParameter("paisId", paisId);
        List<Estado> estadosDoPais = query.getResultList();
        if (!estadosDoPais.isEmpty() && estadoId == null) {
            errors.rejectValue("estadoId", "StateNotNull", "Estado não pode ser nulo para o país informado.");
        }
    }

}
