package cn.tuyucheng.taketoday.metrics.servo;

import com.netflix.servo.monitor.*;
import com.netflix.servo.stats.StatsConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.Collectors.toMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MetricTypeManualTest {

   private static String getMonitorTagValue(Monitor monitor, String tagKey) {
      return monitor
            .getConfig()
            .getTags()
            .getTag(tagKey)
            .getValue();
   }

   @Test
   void givenDefaultCounter_whenManipulate_thenCountValid() {
      Counter counter = Monitors.newCounter("test");
      assertEquals(0, counter
            .getValue()
            .intValue(), "counter should start with 0");
      counter.increment();
      assertEquals(1, counter
            .getValue()
            .intValue(), "counter should have increased by 1");
      counter.increment(-1);
      assertEquals(0, counter
            .getValue()
            .intValue(), "counter should have decreased by 1");
   }

   @Test
   void givenBasicCounter_whenManipulate_thenCountValid() {
      Counter counter = new BasicCounter(MonitorConfig
            .builder("test")
            .build());
      assertEquals(0, counter
            .getValue()
            .intValue(), "counter should start with 0");
      counter.increment();
      assertEquals(1, counter
            .getValue()
            .intValue(), "counter should have increased by 1");
      counter.increment(-1);
      assertEquals(0, counter
            .getValue()
            .intValue(), "counter should have decreased by 1");
   }

   @Disabled
   @Test
   void givenStepCounter_whenManipulate_thenRateValid() throws Exception {
      System.setProperty("servo.pollers", "1000");
      Counter counter = new StepCounter(MonitorConfig
            .builder("test")
            .build());
      assertEquals(0.0, counter.getValue(), "counter should start with rate 0.0");

      counter.increment();
      SECONDS.sleep(1);

      assertEquals(1.0, counter.getValue(), "counter rate should have increased to 1.0");
   }

   @Test
   void givenPeakRateCounter_whenManipulate_thenPeakRateReturn() throws Exception {
      Counter counter = new PeakRateCounter(MonitorConfig
            .builder("test")
            .build());
      assertEquals(0, counter
            .getValue()
            .intValue(), "counter should start with 0");

      counter.increment();
      SECONDS.sleep(1);
      counter.increment();
      counter.increment();

      assertEquals(2, counter
            .getValue()
            .intValue(), "peak rate should have be 2");
   }

   @Test
   void givenTimer_whenExecuteTask_thenTimerUpdated() throws Exception {
      BasicTimer timer = new BasicTimer(MonitorConfig
            .builder("test")
            .build(), MILLISECONDS);

      Stopwatch stopwatch = timer.start();
      SECONDS.sleep(1);
      timer.record(2, SECONDS);
      stopwatch.stop();

      assertEquals(1000, timer
            .getValue()
            .intValue(), 1000, "timer should count 1 second");
      assertEquals(3000, timer.getTotalTime()
            .intValue(), 1000, "timer should count 3 second in total");
      assertEquals(2, timer
            .getCount()
            .intValue(), "timer should record 2 updates");

      assertEquals(2000, timer.getMax(), 0.01, "timer should have max 2");
   }

   @Test
   void givenBucketTimer_whenRecord_thenStatsCalculated() throws Exception {
      BucketTimer timer = new BucketTimer(MonitorConfig
            .builder("test")
            .build(), new BucketConfig.Builder()
            .withBuckets(new long[]{2L, 5L})
            .withTimeUnit(SECONDS)
            .build(), SECONDS);
      timer.record(3);
      timer.record(6);

      assertEquals(9, timer
            .getTotalTime()
            .intValue(), "timer should count 9 seconds in total");

      final Map<String, Long> metricMap = timer
            .getMonitors()
            .stream()
            .filter(monitor -> monitor
                  .getConfig()
                  .getTags()
                  .containsKey("servo.bucket"))
            .collect(toMap(monitor -> getMonitorTagValue(monitor, "servo.bucket"), monitor -> (Long) monitor.getValue()));

      assertThat(metricMap, allOf(hasEntry("bucket=2s", 0L), hasEntry("bucket=5s", 1L), hasEntry("bucket=overflow", 1L)));
   }

   @Test
   void givenStatsTimer_whenExecuteTask_thenStatsCalculated() throws Exception {
      System.setProperty("netflix.servo", "1000");
      StatsTimer timer = new StatsTimer(MonitorConfig
            .builder("test")
            .build(), new StatsConfig.Builder()
            .withComputeFrequencyMillis(2000)
            .withPercentiles(new double[]{99.0, 95.0, 90.0})
            .withPublishMax(true)
            .withPublishMin(true)
            .withPublishCount(true)
            .withPublishMean(true)
            .withPublishStdDev(true)
            .withPublishVariance(true)
            .build(), MILLISECONDS);

      Stopwatch stopwatch = timer.start();
      SECONDS.sleep(1);
      timer.record(3, SECONDS);
      stopwatch.stop();

      stopwatch = timer.start();
      timer.record(6, SECONDS);
      SECONDS.sleep(2);
      stopwatch.stop();

      assertEquals(12000, timer.getTotalTime(), 500, "timer should count 12 seconds in total");
      assertEquals(12000, timer.getTotalMeasurement(), 500, "timer should count 12 seconds in total");
      assertEquals(4, timer.getCount(), "timer should record 4 updates");
      assertEquals(3000, timer
            .getValue()
            .intValue(), 500, "stats timer value time-cost/update should be 2");

      final Map<String, Number> metricMap = timer
            .getMonitors()
            .stream()
            .collect(toMap(monitor -> getMonitorTagValue(monitor, "statistic"), monitor -> (Number) monitor.getValue()));

      assertThat(metricMap.keySet(), containsInAnyOrder("count", "totalTime", "max", "min", "variance", "stdDev", "avg", "percentile_99", "percentile_95", "percentile_90"));
   }

   @Test
   void givenGauge_whenCall_thenValueReturned() {
      Gauge<Double> gauge = new BasicGauge<>(MonitorConfig
            .builder("test")
            .build(), () -> 2.32);
      assertEquals(2.32, gauge.getValue(), 0.01);
   }

   @Test
   void givenMaxGauge_whenUpdateMultipleTimes_thenMaxReturned() {
      MaxGauge gauge = new MaxGauge(MonitorConfig
            .builder("test")
            .build());
      assertEquals(0, gauge
            .getValue()
            .intValue());

      gauge.update(4);
      assertEquals(4, gauge.getCurrentValue(0));

      gauge.update(1);
      assertEquals(4, gauge.getCurrentValue(0));
   }

   @Test
   void givenInformationalMonitor_whenRecord_thenInformationCollected() throws Exception {
      BasicInformational informational = new BasicInformational(MonitorConfig
            .builder("test")
            .build());
      informational.setValue("information collected");
      assertEquals("information collected", informational.getValue());
   }
}