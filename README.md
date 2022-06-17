# Cranberry

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
Cranberry          
```

The Cranberry is a java library that allows to write less routine code. It's automatically plugs into you build during compilation and sweets up your project.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.ololx.cranberry/cranberry.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.ololx.cranberry%22) [![Sonatype Nexus Release](https://img.shields.io/nexus/r/io.github.ololx.cranberry/cranberry?label=Nexus%20Release&nexusVersion=2&server=https%3A%2F%2Fs01.oss.sonatype.org)](https://search.maven.org/search?q=g:%22io.github.ololx.cranberry%22)
[![Sonatype Nexus Snapshot](https://img.shields.io/nexus/s/io.github.ololx.cranberry/cranberry?label=Nexus%20Snapshot&server=https%3A%2F%2Fs01.oss.sonatype.org)](https://search.maven.org/search?q=g:%22io.github.ololx.cranberry%22) [![javadoc](https://javadoc.io/badge2/io.github.ololx.cranberry/cranberry/javadoc.svg?logo=java)](https://javadoc.io/doc/io.github.ololx.cranberry) 

[![tag](https://img.shields.io/github/v/tag/ololx/cranberry?style=flat&include_prereleases&logo=github)](https://github.com/ololx/cranberry/tags) [![release](https://img.shields.io/github/v/release/ololx/cranberry?style=flat&include_prereleases&logo=github)](https://github.com/ololx/cranberry/releases)

[![osslifecycle](https://img.shields.io/osslifecycle/ololx/cranberry?style=flat)](OSSMETADATA) [![last_commit](https://img.shields.io/github/last-commit/ololx/cranberry?style=flat&logo=github)](https://github.com/ololx/cranberry/commits) [![release_date](https://img.shields.io/github/release-date/ololx/cranberry?style=flat&logo=github)](https://github.com/ololx/cranberry/releases) 

[![build](https://img.shields.io/github/workflow/status/ololx/cranberry/Build?label=build&logo=github-actions&style=flat)](https://github.com/ololx/cranberry/actions/workflows/build.yml) [![codeql](https://img.shields.io/github/workflow/status/ololx/cranberry/CodeQL?label=CodeQL&logo=github-actions&style=flat)](https://github.com/ololx/cranberry/actions/workflows/codeql.yml) [![tests](https://img.shields.io/github/workflow/status/ololx/cranberry/Tests?label=tests&logo=github-actions&style=flat)](https://github.com/ololx/cranberry/actions/workflows/test.yml) [![codecov](https://codecov.io/gh/ololx/cranberry/branch/main/graph/badge.svg?token=ERMIS664SR)](https://codecov.io/gh/ololx/cranberry) [![DeepSource](https://deepsource.io/gh/ololx/cranberry.svg/?label=active+issues&show_trend=true&token=fKuT1NGwxvQWyqxHxzRDvAYS)](https://deepsource.io/gh/ololx/cranberry/?ref=repository-badge) [![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/ololx/cranberry.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/ololx/cranberry/context:java) [![Total alerts](https://img.shields.io/lgtm/alerts/g/ololx/cranberry.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/ololx/cranberry/alerts/) [![Codacy Badge](https://app.codacy.com/project/badge/Grade/3cdf2b4dacbe445ca4ccfd0db41e4968)](https://www.codacy.com/gh/ololx/cranberry/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ololx/cranberry&amp;utm_campaign=Badge_Grade)

[![licence](https://img.shields.io/github/license/ololx/cranberry?style=flat)](LICENCE) [![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg?style=flat)](CODE_OF_CONDUCT.md) [![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fololx%2Fcranberry.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fololx%2Fcranberry?ref=badge_shield)

![repo_size](https://img.shields.io/github/repo-size/ololx/cranberry?style=flat&logo=github) ![languages_code_size](https://img.shields.io/github/languages/code-size/ololx/cranberry?style=flat&logo=github) ![languages_count](https://img.shields.io/github/languages/count/ololx/cranberry?style=flat&logo=github) ![languages_top](https://img.shields.io/github/languages/top/ololx/cranberry?style=flat&logo=github)

[![requires_java](https://img.shields.io/badge/requires_java-1.8+-important)](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)

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

The Cranberry is a java library that allows to write less routine code. It's automatically plugs into you build during compilation and sweets up your project. 

### Motivation

Sometimes it wants frequently used code to be generated automatically. Especially if such code is not generated by existing libraries.

### Modules

The cranberry project includes the follows modules:

- [cranberry commons](cranberry-commons/README.md) - this module provides a general realisation of simple tools and wrappers which are used in another cranberry modules for the automatically code generating during compilation;
- [cranberry muffin](cranberry-muffin/README.md) - this module  is designed to combine the possibilities of thematically grouped modules into one common library;
- [cranberry statement](cranberry-statement/README.md) - this module provides an api for the statements validation (such as not null and e.t.c.). This module includes an annotations for the injecting methods of this api into code during compilation;
- [cranberry logging](cranberry-logging/README.md) - this module provides an api for the loggint method params;
- [cranberry data](cranberry-data/README.md) - this module provides an api for the java data manipulations: varianbles modifiers, default values, e.t.c. This module includes an annotations for the injecting methods of this api into code during compilation;
- [cranberry tests](cranberry-tests/README.md) - this module contains the unit tests for the remaining modules of the cranberry project.

## 📸 Demo

The demonstration shows how `cranberry` helps to write less code on the checking parameters implementation example for non-emptiness via usage of the `@ NotEmpty` annotation from the `cranberry-statement` module. This is one of opportunities which cranberry provides.

![The demo of cranberry statement usage](https://github.com/ololx/cranberry/blob/assets/demo/cranberry-statements-not-blank-demo-1.gif?raw=true)

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

1 - Add this dependency to classpath in pom:

```xml
<dependency>
    <groupId>io.github.ololx.cranberry</groupId>
    <artifactId>${module-name}</artifactId>
    <version>${version}</version>
</dependency>
```

_Example of dependency for installing `cranberry-muffin` module with version `0.5.3` is presented bellow_

```xml
<dependency>
    <groupId>io.github.ololx.cranberry</groupId>
    <artifactId>cranberry-muffin</artifactId>
    <version>0.5.3</version>
    <scope>provided</scope>
</dependency>
```

2 - Execute this with goal

```bash
clean install
```

### Cloning

For the cloning this repository to a local machine, just use the follows link:

```https
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


[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fololx%2Fcranberry.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fololx%2Fcranberry?ref=badge_large)
