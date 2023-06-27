package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.client.AmqpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AmqpClient.class)
public class SpringContextTest {

   @Test
   public void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}