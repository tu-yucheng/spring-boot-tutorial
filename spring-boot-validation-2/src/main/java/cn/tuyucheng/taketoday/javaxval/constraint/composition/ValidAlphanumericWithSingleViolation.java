package cn.tuyucheng.taketoday.javaxval.constraint.composition;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotNull
@Pattern(regexp = ".*\\d.*", message = "must contain at least one numeric character")
@Length(min = 6, max = 32, message = "must have between 6 and 32 characters")
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
@ReportAsSingleViolation
public @interface ValidAlphanumericWithSingleViolation {

   String message() default "field should have a valid length and contain numeric character(s).";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};

}