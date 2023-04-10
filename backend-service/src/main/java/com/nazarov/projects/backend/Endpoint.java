package com.nazarov.projects.backend;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.NonNull;

public abstract class Endpoint<T extends Endpoint<T>> implements RestEndpoint {

  private final FilterableRequestSpecification defaultReqSpec;
  protected FilterableRequestSpecification reqSpec;
  protected ResponseSpecification respSpec;

  public Endpoint(@NonNull FilterableRequestSpecification reqSpec,
      @NonNull ResponseSpecification respSpec) {
    this.reqSpec = (FilterableRequestSpecification) reqSpec.basePath(
        reqSpec.getBasePath() + this.getPath());
    this.respSpec = respSpec;
    this.defaultReqSpec = reqSpecDeepCopy(reqSpec);
  }

  public FilterableRequestSpecification getReqSpec() {
    return (reqSpecDeepCopy(reqSpec));
  }

  public T setReqSpec(FilterableRequestSpecification reqSpec) {
    this.reqSpec = reqSpec;
    return (T) this;
  }

  public ResponseSpecification getRespSpec() {
    return respSpecDeepCopy(respSpec);
  }

  public T setRespSpec(ResponseSpecification respSpec) {
    this.respSpec = respSpec;
    return (T) this;
  }

  private FilterableRequestSpecification reqSpecDeepCopy(FilterableRequestSpecification spec) {
    // returns effective deep copy of the request specification
    return (FilterableRequestSpecification) new RequestSpecBuilder().addRequestSpecification(
        spec).build();
  }

  private ResponseSpecification respSpecDeepCopy(ResponseSpecification spec) {
    // returns effective deep copy of the response specification
    return new ResponseSpecBuilder().addResponseSpecification(spec).build();
  }


}
