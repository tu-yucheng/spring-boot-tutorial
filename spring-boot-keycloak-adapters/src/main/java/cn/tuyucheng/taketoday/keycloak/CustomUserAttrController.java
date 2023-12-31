package cn.tuyucheng.taketoday.keycloak;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Map;

@Controller
public class CustomUserAttrController {

   @GetMapping(path = "/users")
   public String getUserInfo(Model model) {
      KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
            .getAuthentication();

      final Principal principal = (Principal) authentication.getPrincipal();

      String dob = "";
      String userIdByToken = "";
      String userIdByMapper = "";

      if (principal instanceof KeycloakPrincipal) {
         KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
         IDToken token = kPrincipal.getKeycloakSecurityContext()
               .getIdToken();

         userIdByToken = token.getSubject();
         userIdByMapper = token.getOtherClaims().get("user_id").toString();

         Map<String, Object> customClaims = token.getOtherClaims();

         if (customClaims.containsKey("DOB")) {
            dob = String.valueOf(customClaims.get("DOB"));
         }
      }

      model.addAttribute("username", principal.getName());
      model.addAttribute("userIDByToken", userIdByToken);
      model.addAttribute("userIDByMapper", userIdByMapper);
      model.addAttribute("dob", dob);
      return "userInfo";
   }
}