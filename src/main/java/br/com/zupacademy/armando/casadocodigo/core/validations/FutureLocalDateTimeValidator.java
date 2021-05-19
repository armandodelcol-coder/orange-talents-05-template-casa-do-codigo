package br.com.zupacademy.armando.casadocodigo.core.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FutureLocalDateTimeValidator implements ConstraintValidator<FutureLocalDateTime, String> {

    private String pattern;

    @Override
    public void initialize(FutureLocalDateTime constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return true;
        }

        DateTimeFormatter padraoData = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDateTime dataEHora = LocalDateTime.parse(value, padraoData);
            return dataEHora.isAfter(LocalDateTime.now());
        } catch (Exception e) {
            return false;
        }
    }

}
