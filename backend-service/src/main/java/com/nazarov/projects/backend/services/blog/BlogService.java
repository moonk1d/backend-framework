package com.nazarov.projects.backend.services.blog;

import java.util.List;
import org.springframework.stereotype.Component;

// TODO: This class to be discussed as it may causes an issue when endpoint is modified in one test
//  and then used in another one, consider to remove the class. Or it can be made as Prototype scope.
@Component
public class BlogService {

  private List<BlogEndpoint> endpoints;

  public BlogService(List<BlogEndpoint> endpoints) {
    this.endpoints = endpoints;
  }

  public <T extends BlogEndpoint> T getEndpoint(Class<T> clazz) {
    return (T) endpoints
        .stream()
        .filter(e -> e.getClass().equals(clazz))
        .findAny()
        .orElseThrow(() -> new RuntimeException());
  }
}
