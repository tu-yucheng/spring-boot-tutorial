package cn.tuyucheng.taketoday.logging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoggingControllerIntegrationTest {

   @Autowired
   TestRestTemplate restTemplate;

   @Test
   public void findById() {
      String res = restTemplate.getForObject("/test/{id}", String.class, 1);

      assertNotNull(res);
      assertEquals("Hello-1", res);
   }

   @Test
   public void postById() {
      String res = restTemplate.postForObject("/test", 1, String.class);

      assertNotNull(res);
      assertEquals("Hello-1", res);
   }
}