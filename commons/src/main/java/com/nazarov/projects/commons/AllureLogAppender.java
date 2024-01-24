package com.nazarov.projects.commons;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import java.util.ArrayList;
import java.util.List;

public class AllureLogAppender extends AppenderBase<ILoggingEvent> {

  private static final ThreadLocal<List<ILoggingEvent>> threadLocal = new ThreadLocal<>();

  public static List<ILoggingEvent> getEvents() {
    return threadLocal.get();
  }

  public static void clearEvents() {
    threadLocal.remove();
  }

  @Override
  public void append(ILoggingEvent e) {
    List<ILoggingEvent> events = threadLocal.get();
    if (events == null) {
      events = new ArrayList<>();
      threadLocal.set(events);
    }
    events.add(e);
  }
}