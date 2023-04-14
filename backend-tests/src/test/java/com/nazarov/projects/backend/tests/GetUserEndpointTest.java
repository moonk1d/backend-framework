package com.nazarov.projects.backend.tests;

import com.nazarov.projects.backend.services.blog.user.GetUserEndpoint;
import com.nazarov.projects.backend.tests.config.TestConfig;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(TestConfig.class)
@Slf4j
public class GetUserEndpointTest {

  @Autowired
  private GetUserEndpoint getUserEndpoint;

  @Test
  public void testGetUserEndpoint_200() {
    RestAssured
        .given(getUserEndpoint.getReqSpec())
        .pathParam("id", 9)
        .when()
        .get()
        .then()
        .statusCode(200);
  }

  @Test
  public void testGetUserService_200() {
    getUserEndpoint.getUser("9").statusCode(200);
  }
}
