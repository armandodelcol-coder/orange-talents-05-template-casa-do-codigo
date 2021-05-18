package br.com.zupacademy.armando.casadocodigo.core.validations;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String fieldName;
    private Class<?> entity;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("SELECT entity from " + entity.getName() + " entity WHERE " + fieldName + " = :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        // Se for encontrado mais de 1 registro, quer dizer que tem algum bug, pois, só pode haver 1 único registro com o fieldName informado.
        Assert.state(list.size() <= 1, "Foi encontrado mais de um " + entity.getName() + " com o atributo " + fieldName + " = " + value);

        return list.isEmpty();
    }

}
