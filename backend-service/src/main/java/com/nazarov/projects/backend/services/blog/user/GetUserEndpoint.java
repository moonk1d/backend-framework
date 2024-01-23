package com.nazarov.projects.backend.services.blog.user;

import static io.restassured.RestAssured.given;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import com.nazarov.projects.backend.models.blog.User;
import com.nazarov.projects.backend.services.blog.BlogEndpoint;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = SCOPE_PROTOTYPE)
public final class GetUserEndpoint extends BlogEndpoint<GetUserEndpoint> {

  private final String path = "/users/{id}";

  public GetUserEndpoint(
      @Qualifier("BlogServiceReqSpec") FilterableRequestSpecification reqSpec,
      @Qualifier("BlogServiceRespSpec") ResponseSpecification respSpec) {
    super(reqSpec, respSpec);
  }

  public String getPath() {
    return path;
  }

  public ValidatableResponse getUserResponse(String userId) {
    return send(userId);
  }

  public User getUser(String userId) {
    return send(userId).statusCode(200).extract().as(User.class);
  }

  private ValidatableResponse send(String userId) {
    return given(reqSpec).pathParam("id", userId).when().get().then();
  }

}
