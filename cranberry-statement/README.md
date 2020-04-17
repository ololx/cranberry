# cranberry statement

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
    <artifactId>cranberry-statement</artifactId>
    <version>${version}</version>
</dependency>
```

_Example of dependency for installing `cranberry-statement` module with version `0.1.0` is presented bellow_

```xml
<dependency>
    <groupId>org.cranberry</groupId>
    <artifactId>cranberry-statement</artifactId>
    <version>0.1.0</version>
</dependency>
```

3 - Execute this with goal

```bash
clean install
```

### Using

 ```java
 ...
//Add the checking statements for method params
public List<SomeDetail> findSomeDetailbyUidAndTypeCode(@NotNull Long uid, 
    @NotEmpty("Type Code must be not empty") String typeCode) {
    return this.getArtefacts(processingArtefactRepository.selectAllWorkingForSurvey(uidSurvey, typeCode));
}
...
 ```