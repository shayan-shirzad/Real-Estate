package ir.sh.realestate.annotation;

import ir.sh.realestate.annotation.impl.NationalCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NationalCodeValidator.class)
public @interface NationalCode {
    String message() default "The national code is invalid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
