package cn.tuyucheng.taketoday.keycloaktestcontainers;

import dasniko.testcontainers.keycloak.KeycloakContainer;
import io.restassured.RestAssured;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class KeycloakTestContainers {

   static final KeycloakContainer keycloak;
   private static final Logger LOGGER = LoggerFactory.getLogger(KeycloakTestContainers.class.getName());

   static {
      keycloak = new KeycloakContainer().withRealmImportFile("keycloak/realm-export.json");
      keycloak.start();
   }

   @LocalServerPort
   private int port;

   @DynamicPropertySource
   static void registerResourceServerIssuerProperty(DynamicPropertyRegistry registry) {
      registry.add("spring.security.oauth2.resourceserver.jwt.issuer-uri", () -> keycloak.getAuthServerUrl() + "/realms/tuyucheng");
   }

   @PostConstruct
   public void init() {
      RestAssured.baseURI = "http://localhost:" + port;
   }

   protected String getJaneDoeBearer() {

      try {
         URI authorizationURI = new URIBuilder(keycloak.getAuthServerUrl() + "/realms/tuyucheng/protocol/openid-connect/token").build();
         WebClient webclient = WebClient.builder()
               .build();
         MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
         formData.put("grant_type", Collections.singletonList("password"));
         formData.put("client_id", Collections.singletonList("tuyucheng-api"));
         formData.put("username", Collections.singletonList("jane.doe@tuyucheng.com"));
         formData.put("password", Collections.singletonList("s3cr3t"));

         String result = webclient.post()
               .uri(authorizationURI)
               .contentType(MediaType.APPLICATION_FORM_URLENCODED)
               .body(BodyInserters.fromFormData(formData))
               .retrieve()
               .bodyToMono(String.class)
               .block();

         JacksonJsonParser jsonParser = new JacksonJsonParser();

         return "Bearer " + jsonParser.parseMap(result)
               .get("access_token")
               .toString();
      } catch (URISyntaxException e) {
         LOGGER.error("Can't obtain an access token from Keycloak!", e);
      }

      return null;
   }
}