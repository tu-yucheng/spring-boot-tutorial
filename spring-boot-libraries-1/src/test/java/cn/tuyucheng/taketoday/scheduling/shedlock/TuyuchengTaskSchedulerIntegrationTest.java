package cn.tuyucheng.taketoday.scheduling.shedlock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TuyuchengTaskSchedulerIntegrationTest {
   @Autowired
   private TuyuchengTaskScheduler taskScheduler;

   @Test
   void whenShedLockConfigCorrect_thenSpringCtxtStartsWithoutError() {
      // save the old out
      PrintStream old = System.out;

      // Create a stream to hold the output for test
      ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(consoleOutput);
      System.setOut(ps);
      // test
      taskScheduler.scheduledTask();
      System.out.flush();
      String expected = "Running ShedLock task\n";
      assertThat(consoleOutput.toString()).hasToString(expected);

      // restore the old out
      System.setOut(old);
   }
}