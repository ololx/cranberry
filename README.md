```
             ___/\\ /\  
            / _//| \ /  
           / / / |/ \__ 000   000
           |/ /  / /  000       000
      00 00 _/   |/ 000       ^   000
   00 ^     00   | 000     <  *  > 000  
  00< * >    00 0 0 000       v   000
   00 v     00 0 * 0  000       000
      00 00     0 0     000   000
________________________________________
             The Cranberry          
```

# cranberry

The Cranberry is a java library that allows to write less code - it's  automatically plugs into your project build and sweets up your java.

[![status](https://img.shields.io/badge/status-active-active?style=flat-square)](BADGES_GUIDE.md#status) [![version](https://img.shields.io/badge/version-0.2.0-informational?style=flat-square)](BADGES_GUIDE.md#version) [![stable](https://img.shields.io/badge/stable-no-important?style=flat-square)](BADGES_GUIDE.md#stable) [![build](https://img.shields.io/badge/build-passing-success?style=flat-square)](BADGES_GUIDE.md#build) [![oss lifecycle](https://img.shields.io/badge/oss_lifecycle-active-important?style=flat-square)](BADGES_GUIDE.md#oss-lifecycle) [![maintenance](https://img.shields.io/badge/maintenance-yes-informational?style=flat-square)](BADGES_GUIDE.md#maintenance) [![latest release date](https://img.shields.io/badge/latest_release_date-August_27,_2020-informational?style=flat-square)](BADGES_GUIDE.md#release-date) [![last commit](https://img.shields.io/badge/last_commit-August_27,_2020-informational?style=flat-square)](BADGES_GUIDE.md#commit-date)

[![license](https://img.shields.io/badge/license-Apache_2.0-informational?style=flat-square)](LICENSE) [![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg)](code_of_conduct.md)

[![platform](https://img.shields.io/badge/java-1.8+-important?style=flat-square)](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)

---

## 📇 Table of Contents

- [About](#about)
- [Demo](#demo)
- [Features](#feature)
- [Getting Started](#getting-started)
- [Built With](#built-with)
- [Contributing](#contributing)
- [Code of Conduct](#code-of-conduct)
- [Versioning](#versioning)
- [Authors](#authors)
- [Licensing](#licensing)

##  📖 About

The Cranberry is a java library that allows to write less code - it's  automatically plugs into your project build and sweets up your java.

### Motivation

Sometimes it wants frequently used code to be generated automatically. Especially if such code is not generated by existing libraries.

### Modules

The cranberry project includes the follows modules:

- [cranberry-muffin](cranberry-muffin/README.md) - this module provides a general realisation of simple tools and wrappers which are used in another cranberry modules for the automatically code generating during compilation;
- [cranberry engine](cranberry-engine/README.md) - this module  is designed to combine the possibilities of thematically grouped modules into one common library;
- [cranberry statement](cranberry-statement/README.md) - this module provides an api for the statements validation (such as not null and e.t.c.). This module includes an annotations for the injecting methods of this api into code during compilation;
- [cranberry logging](cranberry-logging/README.md) - this module provides an api for the loggint method params;
- [cranberry tests](cranberry-tests/README.md) - this module contains the unit tests for the remaining modules of the cranberry project.

## 📸 Demo

The demonstration shows how `cranberry` helps to write less code on the checking parameters implementation example for non-emptiness via usage of the `@ NotEmpty` annotation from the `cranberry-statement` module. This is one of opportunities which cranberry provides.

![The demo of cranberry statement usage](https://github.com/ololx/cranberry/blob/cranberry-assets/demo/cranberry-statements-not-blank-demo-1.gif?raw=true)

## 🎚 Features

- The api for the statements validation about not null values of the `Object` type;
- The api for the statements validation about not empty values of the `Map` type, the `Collection` type, the `Array` and the `String` type;
- The api for the statements validation about not blank values of the `String` type; 
- The api for the loggint method params;
- The annotations for the injecting methods of this api into code during compilation.

### To Do

- For more information on an upcoming development, please read the [todo](TODO.md) list.

### Changelog

- For more information on a releases, a features and a changes, please read the [changelog](CHANGELOG.md) notes.

## 🚦 Getting Started

These instructions allow to get a copy of this project and run it on a local machine.

### Prerequisites

Before using it, make sure that follows software are installed on the local machine:

- **[Oracle JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)** - the java development kit.

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
    <artifactId>${module-name}</artifactId>
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

### Cloning

For the cloning this repository to a local machine, just use the follows link:

```http
https://github.com/ololx/cranberry
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

The simple example below presents the the logging of a parameters of method with the specific message.

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

## 🛠 Built With

- **[Maven](https://maven.apache.org/)** - Dependency Management.

## 🎉 Contributing

If you want to contribute this project - you are welcome and have fun.
Please visit the [contributing](CONTRIBUTING.md) section for details on this code of conduct, and the process for submitting pull requests.

## 📝 Code of Conduct

In order to ensure that all is welcoming, please review and abide by the [code of conduct](CODE_OF_CONDUCT.md).

## 🗒 Versioning

For the versioning is used [Semantic Versioning](http://semver.org/). For the versions available, see the [changelog](CHANGELOG.md) or the tags on this repository.

## ©️ Authors

* **Alexander A. Kropotin** - *Initial work* - [ololx](https://github.com/ololx).

## 🔏 Licensing

This project is licensed under the Apache license version 2.0 - see the [lisence](LICENSE) document for details.
