package cn.tuyucheng.taketoday.javaxval.enums.constraints;

import cn.tuyucheng.taketoday.javaxval.enums.EnumNamePatternValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = EnumNamePatternValidator.class)
public @interface EnumNamePattern {

   /**
    * @return the regular expression to match
    */
   String regexp();

   /**
    * @return the error message template
    */
   String message() default "must match \"{regexp}\"";

   /**
    * @return the groups the constraint belongs to
    */
   Class<?>[] groups() default {};

   /**
    * @return the payload associated to the constraint
    */
   Class<? extends Payload>[] payload() default {};
}