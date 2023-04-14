package com.nazarov.projects.backend.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.nazarov.projects.backend.services.blog.user.GetUserEndpoint;
import com.nazarov.projects.backend.tests.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(TestConfig.class)
@Slf4j
public class ContextTest {

  @Autowired
  private GetUserEndpoint getUserEndpoint;

  @Test
  public void testContext() {
    assertNotNull(getUserEndpoint);
  }


}
