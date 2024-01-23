package com.nazarov.projects.backend.services.blog;

import com.nazarov.projects.backend.Endpoint;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.NonNull;

public abstract class BlogEndpoint<T extends BlogEndpoint<T>> extends Endpoint<T> {

  public BlogEndpoint(@NonNull FilterableRequestSpecification reqSpec,
      @NonNull ResponseSpecification respSpec) {
    super(reqSpec, respSpec);
  }
}
