package cn.tuyucheng.taketoday.failureanalyzer.utils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.util.ArrayList;
import java.util.List;

public class ListAppender extends AppenderBase<ILoggingEvent> {

   private static final List<ILoggingEvent> events = new ArrayList<>();

   public static List<ILoggingEvent> getEvents() {
      return events;
   }

   public static void clearEventList() {
      events.clear();
   }

   @Override
   protected void append(ILoggingEvent eventObject) {
      events.add(eventObject);
   }
}