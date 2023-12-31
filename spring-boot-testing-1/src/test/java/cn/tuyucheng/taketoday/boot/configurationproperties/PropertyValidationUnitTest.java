package cn.tuyucheng.taketoday.boot.configurationproperties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = MailServer.class)
@TestPropertySource("classpath:property-validation-test.properties")
class PropertyValidationUnitTest {

   private static Validator propertyValidator;
   @Autowired
   private MailServer mailServer;

   @BeforeAll
   static void setup() {
      propertyValidator = Validation.buildDefaultValidatorFactory()
            .getValidator();
   }

   @Test
   void whenBindingPropertiesToValidatedBeans_thenConstrainsAreChecked() {
      assertEquals(0, propertyValidator.validate(mailServer.getPropertiesMap()).size());
      assertEquals(0, propertyValidator.validate(mailServer.getMailConfig()).size());
   }
}