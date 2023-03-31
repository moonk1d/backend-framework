package com.nazarov.projects.backend;

import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Getter;
import lombok.NonNull;

@Getter
public abstract class Endpoint implements RestEndpoint {

  protected FilterableRequestSpecification reqSpec;
  protected ResponseSpecification respSpec;

  public Endpoint(@NonNull FilterableRequestSpecification reqSpec,
      @NonNull ResponseSpecification respSpec) {
    this.reqSpec = (FilterableRequestSpecification) reqSpec.basePath(
        reqSpec.getBasePath() + this.getPath());
    this.respSpec = respSpec;
  }

}
