package com.nazarov.projects.backend.services.blog.post;

import static io.restassured.RestAssured.given;

import com.nazarov.projects.backend.services.blog.BlogEndpoint;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public final class GetPostEndpoint extends BlogEndpoint {

  private final String path = "/posts/{id}";

  public GetPostEndpoint(
      @Qualifier("BlogServiceReqSpec") FilterableRequestSpecification reqSpec,
      @Qualifier("BlogServiceRespSpec") ResponseSpecification respSpec) {
    super(reqSpec, respSpec);
  }

  public String getPath() {
    return path;
  }

  public ValidatableResponse getPost(String postId) {
    return send(postId);
  }

  private ValidatableResponse send(String postId) {
    return given(reqSpec).pathParam("id", postId).when().get().then();
  }
}
