package cn.tuyucheng.taketoday.annotations.service;

import cn.tuyucheng.taketoday.annotations.service.abstracts.AbstractAuthenticationService;
import cn.tuyucheng.taketoday.annotations.service.interfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication {

   @Autowired
   private AuthenticationService inMemoryAuthService;

   @Autowired
   private AbstractAuthenticationService ldapAuthService;

   public static void main(String[] args) {
      SpringApplication.run(AuthApplication.class, args);
   }
}