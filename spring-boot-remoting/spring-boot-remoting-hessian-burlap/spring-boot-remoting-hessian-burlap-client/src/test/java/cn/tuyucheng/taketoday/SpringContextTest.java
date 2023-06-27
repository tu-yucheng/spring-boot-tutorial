package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.client.BurlapClient;
import cn.tuyucheng.taketoday.client.HessianClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {BurlapClient.class, HessianClient.class})
@RunWith(SpringRunner.class)
public class SpringContextTest {

   @Test
   public void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}
