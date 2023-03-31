package com.nazarov.projects.backend.config;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
@ComponentScan("com.nazarov.projects.backend")
@PropertySource("classpath:application.properties")
public class ServiceConfig {

  @Value("${api.baseUri}")
  private String baseUri;

  @Value("${api.blog.baseUri}")
  private String blogServiceUri;

  @Value("${api.blog.apiKey}")
  private String blogApiKey;

  @Scope(value = SCOPE_PROTOTYPE)
  @Bean(name = "BlogServiceReqSpec")
  public FilterableRequestSpecification blogServiceReqSpec() {
    log.info("Configuring request specification for Blog service");
    return (FilterableRequestSpecification) getBaseRequestSpecBuilder()
        .setBaseUri(baseUri)
        .setBasePath(blogServiceUri)
        .build();
  }

  @Scope(value = SCOPE_PROTOTYPE)
  @Bean(name = "BlogServiceRespSpec")
  public ResponseSpecification blogServiceRespSpec() {
    return new ResponseSpecBuilder().build();
  }

  private RequestSpecBuilder getBaseRequestSpecBuilder() {
    return new RequestSpecBuilder()
        .addFilter(new RequestLoggingFilter())
        .addFilter(new ResponseLoggingFilter())
        .addFilter(new AllureRestAssured())
        .setContentType(ContentType.JSON);
  }
}
