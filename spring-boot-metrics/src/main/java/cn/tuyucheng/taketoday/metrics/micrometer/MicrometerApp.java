package cn.tuyucheng.taketoday.metrics.micrometer;

import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicrometerApp {

   public static void main(String[] args) {
      SpringApplication.run(MicrometerApp.class, args);
   }

   @Bean
   JvmThreadMetrics threadMetrics() {
      return new JvmThreadMetrics();
   }
}