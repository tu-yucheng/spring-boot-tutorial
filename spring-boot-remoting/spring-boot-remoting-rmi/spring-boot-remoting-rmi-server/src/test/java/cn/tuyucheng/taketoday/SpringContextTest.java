package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.server.RmiServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RmiServer.class)
@RunWith(SpringRunner.class)
public class SpringContextTest {

   @Test
   public void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}
