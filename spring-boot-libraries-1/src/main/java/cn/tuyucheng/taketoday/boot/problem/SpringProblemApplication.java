package cn.tuyucheng.taketoday.boot.problem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
@ComponentScan("cn.tuyucheng.taketoday.boot.problem")
public class SpringProblemApplication {

   public static void main(String[] args) {
      System.setProperty("spring.profiles.active", "problem");
      SpringApplication.run(SpringProblemApplication.class, args);
   }
}