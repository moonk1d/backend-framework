package com.nazarov.projects.commons;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import java.util.ArrayList;
import java.util.List;

public class AllureLogAppender extends AppenderBase<ILoggingEvent> {

  private static final ThreadLocal<List<ILoggingEvent>> THREAD_LOCAL_EVENTS = new ThreadLocal<>();

  public static List<ILoggingEvent> getEvents() {
    return THREAD_LOCAL_EVENTS.get();
  }

  public static void clearEvents() {
    THREAD_LOCAL_EVENTS.remove();
  }

  @Override
  public void append(ILoggingEvent e) {
    List<ILoggingEvent> events = THREAD_LOCAL_EVENTS.get();
    if (events == null) {
      events = new ArrayList<>();
      THREAD_LOCAL_EVENTS.set(events);
    }
    events.add(e);
  }
}