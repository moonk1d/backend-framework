package com.nazarov.projects.backend.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.nazarov.projects.backend.services.blog.BlogService;
import com.nazarov.projects.backend.services.blog.post.GetPostEndpoint;
import io.restassured.RestAssured;
import com.nazarov.projects.backend.services.blog.user.GetUserEndpoint;
import com.nazarov.projects.backend.tests.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(TestConfig.class)
public class ContextTest {

  @Autowired
  private BlogService blogService;

  @Test
  public void testContext() {
    assertNotNull(blogService);
  }

  @Test
  public void testGetUserEndpoint_200() {
    RestAssured
        .given(blogService.getEndpoint(GetUserEndpoint.class).getReqSpec())
        .pathParam("id", 9)
        .when()
        .get()
        .then()
        .statusCode(200);
  }

  @Test
  public void testGetUserService_200() {
    blogService.getEndpoint(GetUserEndpoint.class).getUser("9").statusCode(200);
  }

  @Test
  public void testGetPostEndpoint_200() {
    RestAssured
        .given(blogService.getEndpoint(GetPostEndpoint.class).getReqSpec())
        .pathParam("id", 10)
        .when()
        .get()
        .then()
        .statusCode(200);
  }

  @Test
  public void testGetPostService_200() {
    blogService
        .getEndpoint(GetPostEndpoint.class)
        .getPost("10")
        .statusCode(200);
  }

}
