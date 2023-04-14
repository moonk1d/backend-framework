package com.nazarov.projects.backend;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.NonNull;

public abstract class Endpoint<T extends Endpoint<T>> implements RestEndpoint<T> {

  private final FilterableRequestSpecification defaultReqSpec;
  private final ResponseSpecification defaultRespSpec;
  protected FilterableRequestSpecification reqSpec;
  protected ResponseSpecification respSpec;

  public Endpoint(@NonNull FilterableRequestSpecification reqSpec,
      @NonNull ResponseSpecification respSpec) {
    this.reqSpec = (FilterableRequestSpecification) reqSpec.basePath(
        reqSpec.getBasePath() + this.getPath());
    this.respSpec = respSpec;
    this.defaultReqSpec = reqSpecDeepCopy(reqSpec);
    this.defaultRespSpec = respSpecDeepCopy(respSpec);
  }

  public FilterableRequestSpecification getReqSpec() {
    return reqSpecDeepCopy(reqSpec);
  }

  public T setReqSpec(FilterableRequestSpecification reqSpec) {
    this.reqSpec = reqSpecDeepCopy(reqSpec);
    return (T) this;
  }

  public FilterableRequestSpecification getDefaultReqSpec() {
    return reqSpecDeepCopy(defaultReqSpec);
  }

  public ResponseSpecification getDefaultRespSpec() {
    return respSpecDeepCopy(defaultRespSpec);
  }

  public T resetReqSpec() {
    this.reqSpec = reqSpecDeepCopy(defaultReqSpec);
    return (T) this;
  }

  public T resetRespSpec() {
    this.respSpec = respSpecDeepCopy(defaultRespSpec);
    return (T) this;
  }

  public ResponseSpecification getRespSpec() {
    return respSpecDeepCopy(respSpec);
  }

  public T setRespSpec(ResponseSpecification respSpec) {
    this.respSpec = respSpecDeepCopy(respSpec);
    return (T) this;
  }

  /**
   * @param spec
   * @return effective deep copy of the provided request specification
   */
  private FilterableRequestSpecification reqSpecDeepCopy(FilterableRequestSpecification spec) {
    return (FilterableRequestSpecification) new RequestSpecBuilder().addRequestSpecification(
        spec).build();
  }

  /**
   * @param spec
   * @return effective deep copy of the provided response specification
   */
  private ResponseSpecification respSpecDeepCopy(ResponseSpecification spec) {
    return new ResponseSpecBuilder().addResponseSpecification(spec).build();
  }


}
