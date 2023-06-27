package cn.tuyucheng.taketoday.javaxval.javabeanconstraints;

import cn.tuyucheng.taketoday.javaxval.javabeanconstraints.entities.UserNotEmpty;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UserNotEmptyUnitTest {

   private static Validator validator;

   @BeforeClass
   public static void setupValidatorInstance() {
      validator = Validation.buildDefaultValidatorFactory()
            .getValidator();
   }

   @Test
   public void whenNotEmptyName_thenNoConstraintViolations() {
      UserNotEmpty user = new UserNotEmpty("John");

      Set<ConstraintViolation<UserNotEmpty>> violations = validator.validate(user);

      assertThat(violations.size()).isEqualTo(0);
   }

   @Test
   public void whenEmptyName_thenOneConstraintViolation() {
      UserNotEmpty user = new UserNotEmpty("");

      Set<ConstraintViolation<UserNotEmpty>> violations = validator.validate(user);

      assertThat(violations.size()).isEqualTo(1);
   }

   @Test
   public void whenNullName_thenOneConstraintViolation() {
      UserNotEmpty user = new UserNotEmpty(null);

      Set<ConstraintViolation<UserNotEmpty>> violations = validator.validate(user);

      assertThat(violations.size()).isEqualTo(1);
   }

   @Test
   public void whenToString_thenCorrect() {
      UserNotEmpty user = new UserNotEmpty("John");

      assertThat(user.toString()).isEqualTo("User{name=John}");
   }
}
