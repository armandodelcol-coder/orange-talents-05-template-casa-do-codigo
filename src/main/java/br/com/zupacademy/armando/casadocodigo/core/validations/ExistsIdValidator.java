package br.com.zupacademy.armando.casadocodigo.core.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> entity;

    @Override
    public void initialize(ExistsId constraintAnnotation) {
        this.entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) return true;

        Query query = entityManager.createQuery("select entity from " + entity.getName() + " entity where id = :id");
        query.setParameter("id", value);
        List resultList = query.getResultList();
        Assert.state(resultList.size() <= 1, "Existem mais de uma entidade " + entity.getName() + " com o mesmo id.");

        return !resultList.isEmpty();
    }

}
