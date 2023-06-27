package cn.tuyucheng.taketoday.metrics.servo;

import com.netflix.servo.publish.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static java.util.concurrent.TimeUnit.SECONDS;

abstract class MetricTestBase {

   MemoryMetricObserver observer;

   @BeforeEach
   public void prepareScheduler() {
      System.setProperty("servo.pollers", "1000");
      observer = new MemoryMetricObserver();
      PollScheduler
            .getInstance()
            .start();
      MetricFilter metricFilter = new BasicMetricFilter(true);
      PollRunnable task = new PollRunnable(new MonitorRegistryMetricPoller(), metricFilter, observer);
      PollScheduler
            .getInstance()
            .addPoller(task, 1, SECONDS);
   }

   @AfterEach
   public void stopScheduler() {
      if (PollScheduler
            .getInstance()
            .isStarted()) {
         PollScheduler
               .getInstance()
               .stop();
      }
   }
}