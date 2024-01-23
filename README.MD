# backend-framework

## Modules structure

+ backend-framework
    - backend-service
    - backend-tests
    - commons

## Allure Log Appender

Add logs to Allure reports.

See `com.nazarov.projects.commons.AllureLogAppender`
and `backend-tests/src/test/resources/logback.xml`

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

## IDE Allure

In case of similar errors, related to Allure when running from IntelliJ or Cucumber CLI runner (does
not influence tests)

```
11:00:10.542 [main] ERROR io.qameta.allure.AllureLifecycle - Could not start step: no test case running
11:00:10.542 [main] ERROR io.qameta.allure.AllureLifecycle - Could not stop step: step with uuid 83bb5628-5483-451d-9b7d-1b2b7712ce57 not found
```

add the following plugin to command line or run configuration

```
--plugin io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm
```
