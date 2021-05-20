package br.com.zupacademy.armando.casadocodigo.estados.validations;

import br.com.zupacademy.armando.casadocodigo.estados.forms.NovoEstadoForm;
import br.com.zupacademy.armando.casadocodigo.estados.models.Estado;
import br.com.zupacademy.armando.casadocodigo.estados.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class StateDuplicateInCountryValidator implements Validator {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(NovoEstadoForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;

        NovoEstadoForm novoEstadoForm = (NovoEstadoForm) target;
        String nomeEstado = novoEstadoForm.getNome();
        Long paisId = novoEstadoForm.getPaisId();

        Optional<Estado> possivelEstado = estadoRepository.findByNomeAndPaisId(nomeEstado, paisId);
        if (possivelEstado.isPresent()) {
            errors.rejectValue("paisId", "StateDuplicateInCountry", "Já existe um estado com esse nome no país informado.");
        }
    }

}
