package cn.tuyucheng.taketoday.boot.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "cn.tuyucheng.taketoday.boot.jsp")
public class SpringBootJspApplication extends SpringBootServletInitializer {


   public static void main(String[] args) {
      SpringApplication.run(SpringBootJspApplication.class);
   }

   // comment below if deploying outside web container -->
   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(SpringBootJspApplication.class);
   }
}