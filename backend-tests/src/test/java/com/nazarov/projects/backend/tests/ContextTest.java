package com.nazarov.projects.backend.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.nazarov.projects.backend.services.blog.BlogService;
import com.nazarov.projects.backend.tests.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(TestConfig.class)
@Slf4j
class ContextTest {

  @Autowired
  private BlogService blogService;

  @Test
  void testContext() {
    assertThat(blogService).isNotNull();
  }


}
