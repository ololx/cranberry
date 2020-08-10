# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/) and this project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased] - yyyy-mm-dd

### Added

- The new statement for the checking logial assertions.

## [0.2.0] - 2020-08-10

### Added

- The module [cranberry logging](cranberry-logging/README.md) which provides an api for the loggint method params. This module includes an annotations for the injecting methods of this api into code during compilation.

## [0.1.0] - 2020-04-17

### Added
- Initial public release of the cranberry with the following modules:
    - The module [cranberry engine](cranberry-engine/README.md) which provides a general realisation of simple tools and wrappers which are used in another cranberry modules for the automatically code generating during compilation;
    - The module [cranberry statement](cranberry-statement/README.md) which provides an api for the statements validation (such as not null and e.t.c.). This module includes an annotations for the injecting methods of this api into code during compilation;
    - The module [cranberry muffin](cranberry-statement/README.md) which is designed to combine the possibilities of thematically grouped modules into one common library;
    - The module [cranberry tests](cranberry-tests/README.md) which will contain the unit tests for the remaining modules of the cranberry project.