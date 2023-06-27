package cn.tuyucheng.taketoday.javaxval.enums.constraints;

import cn.tuyucheng.taketoday.javaxval.enums.CustomerTypeSubSetValidator;
import cn.tuyucheng.taketoday.javaxval.enums.demo.CustomerType;
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
@Constraint(validatedBy = CustomerTypeSubSetValidator.class)
public @interface CustomerTypeSubset {
   /**
    * @return subset of CustomerType enum
    */
   CustomerType[] anyOf();

   /**
    * @return the error message template
    */
   String message() default "must be any of {anyOf}";

   /**
    * @return the groups the constraint belongs to
    */
   Class<?>[] groups() default {};

   /**
    * @return the payload associated to the constraint
    */
   Class<? extends Payload>[] payload() default {};
}
