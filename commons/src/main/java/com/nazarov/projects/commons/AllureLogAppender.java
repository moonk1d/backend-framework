package com.nazarov.projects.commons;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import io.qameta.allure.Allure;

public class AllureLogAppender extends AppenderBase<ILoggingEvent> {

  @Override
  protected void append(ILoggingEvent loggingEvent) {
    Allure.step("[Logback] " + loggingEvent.getFormattedMessage());
  }
}

