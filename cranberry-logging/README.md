# cranberry logging

The cranberry statement is a module of cranberry library (see [Cranberry](../README.md)). This module provides an api for the checking statements (such as not null and e.t.c.). This module includes an annotations for the injecting methods of this api into code during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

## 🚦 Getting Started

These instructions allow to get a copy of this project and run it on a local machine.

### Installing

#### Using Maven

In order to add cranberry to your project it is quite simple to:

1 - Add this repository to repositories in pom:

```xml
<repository>
    <id>cranberry-repository</id>
    <url>https://raw.github.com/ololx/cranberry/cranberry-repository/</url>
    <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
    </snapshots>
</repository>
```

2 - Add this dependency to classpath in pom:

```xml
<dependency>
    <groupId>org.cranberry</groupId>
    <artifactId>cranberry-logging</artifactId>
    <version>${version}</version>
</dependency>
```

_Example of dependency for installing `cranberry-logging` module with version `0.2.0` is presented bellow_

```xml
<dependency>
    <groupId>org.cranberry</groupId>
    <artifactId>cranberry-statement</artifactId>
    <version>0.2.0</version>
</dependency>
```

3 - Execute this with goal

```bash
clean install
```

### Using

 ```java
 ...
/**
 * The example of {@code @LogParam} annotation usage on {@code List<String> param}.
 * <p>
 * When this method is called, the parameters will be displayed in the log;
 * Messages in the log will label the format {@char "message param"} for each parameter.
 */
@LogParam(message = "Start execution with param =")
public static void runWithCustomMessage(List<String> param) {
    param.stream()
            .forEach(eachParam -> {
                System.out.println(eachParam);
            });
}
...
 ```