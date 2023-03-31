package com.nazarov.projects.backend.services.blog;

import java.util.List;
import org.springframework.stereotype.Component;

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
