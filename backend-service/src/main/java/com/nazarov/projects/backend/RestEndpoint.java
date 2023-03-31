package com.nazarov.projects.backend;

import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.ResponseSpecification;

public interface RestEndpoint {

  FilterableRequestSpecification getReqSpec();

  ResponseSpecification getRespSpec();

  String getPath();

}
