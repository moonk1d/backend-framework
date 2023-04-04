# backend-framework

## Modules structure

+ backend-framework
    - backend-service
    - backend-tests
    - commons

## Allure Log Appender

## Command line

### Build modules

```shell
$ mvn clean install -DskipTests=true
```

### Run tests with default "local" configuration

```shell
$ mvn -f backend-tests/pom.xml clean test
```

### Run tests with configuration based on `env` param.

```shell
$ mvn -f backend-tests/pom.xml clean test -Denv=dev
```

### Generate Allure report

```shell
$ mvn -f backend-tests/pom.xml allure:report
```