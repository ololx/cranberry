# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/) and this project 
adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased] - yyyy-mm-dd

### Added

- The new statement for the checking logical assertions.

## [0.14.2] - 2023-09-18

## Fixed

- Improve array string representation of `@LogParam` annotation - print elements of arrays.

## [0.14.1] - 2023-09-13

## Fixed

- Improve `equals()`, `hashCode()` and `toString()` methods for array type in `ValueWrapper`.

## [0.14.0] - 2022-01-31

## Added

- Init new annotation for static modifiers.

## [0.13.1] - 2022-06-17

### Fixed

- TestNG is vulnerable to Path Traversal vulnerability - update dependency for testng from 
  version 7.1.0 to 7.6.1.

## [0.13.0] - 2022-06-17

### Fixed

- Fatal: super() could be on a first place #18. An error occurs when using an annotation
  from a statement package in a constructor. The error is related to the fact that the super()
  keyword must be the first one in the constructor.

### Added

- Init new AbstractTrickyProcessor for the providing the simplest way for tricky processing
  (using task listeners instead #process method).

## [0.12.1] - 2022-02-14

### Fixed

- The JDK 16+ compilation problems - add compilation args to export `jdk.compiler`.

## [0.12.0] - 2022-02-13

### Removed

- The `IncludeVarsLocal` annotation.
- The `TargetAnnotationTypes` annotation.

## [0.11.1] - 2022-01-31

### Fixed

- Fatal: super() could be on a first place #18. An error occurs when using an annotation
  from a statement package in a constructor. The error is related to the fact that the super() 
  keyword must be the first one in the constructor.

## Added

- Init new AbstractTrickyProcessor for the providing the simplest way for tricky processing
  (using task listeners instead #process method)

## [0.10.0] - 2022-01-23

### Added

- Internal informing annotations for the marking program elements like:
    - unstable;
    - for removal;
    - for experimental usage.

## [0.9.1] - 2022-01-09

### Changed

- Change the main POM - add auto plugin running for verifying dependencies.

### Fixed

- Fix `NullPointerException` in the method `getSupportedSourceVersion()` of the `CranberryAbstractProcessor`.

## [0.9.0] - 2022-01-09

### Changed

- Better processing local variables annotated by `Statement` annotations. Now there is no need
  for additional annotation of a method or class with an annotation `IncludeVarsLocal`
  so that the `Statement` annotation processor could to process local variables.

### Deprecated

- The `IncludeVarsLocal` annotation is deprecated now. Because new annotation processing
  could to scan local variables during `ENTER` compilation phase.

## [0.8.0] - 2022-01-07

### Added

- Define the class `AbstractCranberryAnnotationProcessing` for the cranberry processing.

## [0.7.1] - 2022-01-06

### Changed

- Migrate to new `groupId` for all submodules.

## [0.6.0] - 2022-01-05

### Added

- The new module `cranberry-data` with annotation `Final` - for the finalizing local variables  
  and params modifiers.

## [0.5.4] - 2022-01-03

### Added

- The realizations of `equals()` and `hasCode()` methods for `ValueWrapper`.

### Changed

- Move `ValueWrapper` class in module `cranberry-commons`.

## [0.5.3] - 2021-12-31

### Added

- The new annotation `@IncludeVarsLocal` - for the processing local vars.

### Changed

- The `StatementAnnotationProcessor` for running on `@IncludeVarsLocal` too.

## [0.5.2] - 2021-12-25

### Changed

- The test framework from `JUnit` to `TestNG`.

### Fixed

- Wrong exception for `NotBlankStatement.check()` method - was `NotEmptyStatementException`,
  but expected `NotBlankStatementException`.

## [0.5.0] - 2021-12-25

### Changed

- The project groupId and packages names.

## [0.4.0] - 2021-12-09

### Changed

- The project POM to Maven Central publication.

## [0.3.1] - 2021-07-11

### Fixed

- The validation type of annotated by `@NotEmpty` target - it was only true for not applicable types.

## [0.3.0] - 2020-08-27

### Added

- The `@True` annotation and `true` statement checker.

## [0.2.0] - 2020-08-10

### Added

- The module [cranberry logging](cranberry-logging/README.md) which provides an api for the logging 
  method params. This module includes an annotations for the injecting methods of this api into code 
  during compilation.

## [0.1.0] - 2020-04-17

### Added
- Initial public release of the cranberry with the following modules:
    - The module [cranberry engine](cranberry-engine/README.md) which provides a general realisation
      of simple tools and wrappers which are used in another cranberry modules for the automatically 
      code generating during compilation.
    - The module [cranberry statement](cranberry-statement/README.md) which provides an api for the 
      statements validation (such as not null and e.t.c.). This module includes an annotations for 
      the injecting methods of this api into code during compilation.
    - The module [cranberry muffin](cranberry-statement/README.md) which is designed to combine the 
      possibilities of thematically grouped modules into one common library.
    - The module [cranberry tests](cranberry-tests/README.md) which will contain the unit tests for 
      the remaining modules of the cranberry project.
