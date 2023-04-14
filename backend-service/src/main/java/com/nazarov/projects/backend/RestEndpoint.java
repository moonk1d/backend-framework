package com.nazarov.projects.backend;

import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.ResponseSpecification;

public interface RestEndpoint<T> {

  FilterableRequestSpecification getReqSpec();

  ResponseSpecification getRespSpec();

  String getPath();

  T setReqSpec(FilterableRequestSpecification reqSpec);

  T setRespSpec(ResponseSpecification respSpec);

  FilterableRequestSpecification getDefaultReqSpec();

  ResponseSpecification getDefaultRespSpec();

  T resetReqSpec();

  T resetRespSpec();

}
