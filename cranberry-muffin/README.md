# cranberry muffin

The cranberry muffin is a module of cranberry library (see [cranberry](../README.md)) and also java library is designed to combine the possibilities of thematically grouped modules into one common library.

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
    <artifactId>cranberry-muffin</artifactId>
    <version>${version}</version>
</dependency>
```

_Example of dependency for installing `cranberry-muffin` module with version `0.1.0` is presented bellow_

```xml
<dependency>
    <groupId>org.cranberry</groupId>
    <artifactId>cranberry-muffin</artifactId>
    <version>0.1.0</version>
</dependency>
```

3 - Execute this with goal

```bash
clean install
```

### Using

The simple example below presents the the checking of a parameters on `not null` value without the specific exception message returns and  `not blank` value with the specific exception message returns.

```java
 ...
//Add the checking statements for method params
public List<SomeDetail> findSomeDetailbyUidAndTypeCode(@NotNull Long uid, 
    @NotEmpty("The Type Code must be not empty") String typeCode) {
    return Collections.EMPTY_LIST;
}
...
```