package com.nazarov.projects.backend.tests.extensions;

import static java.util.Objects.nonNull;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.nazarov.projects.commons.AllureLogAppender;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

@Slf4j
public class AllureLoggingExtension implements BeforeEachCallback, AfterEachCallback {

  private static final Function<ILoggingEvent, String> eventFormatter = event -> {
    var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS").withZone(ZoneId.systemDefault());

    return String.format("[%s] [%s] [%s] - %s",
        formatter.format(event.getInstant()),
        event.getLevel(),
        event.getLoggerName(),
        event.getFormattedMessage());
  };

  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    AllureLogAppender.clearEvents();
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) {
    List<ILoggingEvent> events = AllureLogAppender.getEvents();
    byte[] log = "Log output is empty".getBytes();
    if (nonNull(events)) {
      log = events.stream()
          .map(eventFormatter)
          .collect(Collectors.joining(System.lineSeparator(), "", System.lineSeparator()))
          .getBytes();
    }
    Allure.addAttachment("log", "text/plain", new ByteArrayInputStream(log), ".log");
  }
}
