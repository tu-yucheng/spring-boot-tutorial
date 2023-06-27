package cn.tuyucheng.taketoday.scheduling.conditional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledJob {

   private final static Logger LOG = LoggerFactory.getLogger(ScheduledJob.class);
   private String source;

   public ScheduledJob(String source) {
      this.source = source;
   }

   @Scheduled(fixedDelay = 60000)
   public void cleanTempDir() {
      LOG.info("Cleaning temp directory via {}", source);
   }
}
