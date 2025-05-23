package com.rahil.mvcdemo.model.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    public String value()

    default "RK";

    public String message()

    default "must start with RK";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
