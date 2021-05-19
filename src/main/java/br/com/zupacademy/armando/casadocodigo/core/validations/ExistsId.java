package br.com.zupacademy.armando.casadocodigo.core.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = { ExistsIdValidator.class })
@Target({ FIELD })
@Retention(RUNTIME)
@Repeatable(ExistsId.List.class)
public @interface ExistsId {

    Class<?> entity();

    String message() default "{javax.validation.constraints.ExistsId.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ FIELD })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        ExistsId[] value();
    }

}
