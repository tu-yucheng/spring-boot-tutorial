package cn.tuyucheng.taketoday.beandefinitionoverrideexception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration1 {

   @Bean
   public TestBean1 testBean() {
      return new TestBean1();
   }

   class TestBean1 {

      private String name;

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }
   }
}