package cn.tuyucheng.taketoday.metrics.aspectj;

import com.codahale.metrics.annotation.Timed;
import io.astefanutti.metrics.aspectj.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Metrics(registry = ObjectRunner.REGISTRY_NAME)
public class ObjectRunner {

   public static final String REGISTRY_NAME = "ObjectRunner";
   private static final Logger logger = LoggerFactory.getLogger(ObjectRunner.class);

   @Timed(name = "timerName")
   public void run() {
      logger.info("run");
      try {
         Thread.sleep(1000L);
      } catch (InterruptedException e) {
      }
   }
}