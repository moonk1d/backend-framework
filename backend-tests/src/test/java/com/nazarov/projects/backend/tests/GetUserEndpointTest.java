package com.nazarov.projects.backend.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.nazarov.projects.backend.models.blog.User;
import com.nazarov.projects.backend.services.blog.user.GetUserEndpoint;
import com.nazarov.projects.backend.tests.config.TestConfig;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(TestConfig.class)
@Slf4j
class GetUserEndpointTest {

  @Autowired
  private GetUserEndpoint getUserEndpoint;

  @Test
  void testGetUserEndpoint_200() {
    RestAssured
        .given(getUserEndpoint.getReqSpec())
        .pathParam("id", 9)
        .when()
        .get()
        .then()
        .statusCode(200);
  }

  @Test
  void testGetUserService_200() {
    getUserEndpoint.getUserResponse("9").statusCode(200);
  }

  @Test
  void testGetUser_200() {
    User user = getUserEndpoint.getUser("9");

    assertThat(user.getId()).isEqualTo(9);
  }

}
