# cranberry engine

The cranberryengine is a module of cranberry library (see [cranberry](../README.md)). This module provides  a general realisation of simple tools and wrappers which are used in another cranberry modules for the automatically 
code generating during compilation.

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
    <artifactId>cranberry-engine</artifactId>
    <version>${version}</version>
</dependency>
```

_Example of dependency for installing `cranberry-engine` module with version `0.1.0` is presented bellow_

```xml
<dependency>
    <groupId>org.cranberry</groupId>
    <artifactId>cranberry-engine</artifactId>
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
//Catching all local variables and params annotated with {@code SomeAnnotation.class} in {@code SomeAnnotationProcessor}
@Override
public synchronized void init(ProcessingEnvironment processingEnvironment) {
    super.init(processingEnvironment);
    Parser parser = Trees.instance(processingEnvironment);
    Task task = JavacTask.instance(processingEnvironment);
         
    //Init cranberry commons compilation scanner instance for getting all annotated elements by filter
    this.scanner = new VariableCompilationTreeScanner(parser);
    this.scanner.setFilter(
            element.getAnnotation(SomeAnnotation) != null
    );
 
    //Init cranberry commons compilation handler instance for running scanner on compilation phase enter
    EnterCompilationHandler handler = new EnterCompilationHandler();
    handler.setFinishHandling(
            (Object event) -> {
                this.scanner.scan(((TaskEvent) event).getCompilationUnit());
            }
    );
    this.task.addTaskListener(handler);
}
 ...
 
//Getting and processing all annotated elements received by cranberry commons compilation scanner at the compilation 
phase enter 
@Override
public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment processingEnvironment) {
    this.scanner.getElements().stream()
            .forEach(element -> {
                ...
                //do something with scanned elements
                ...
                    }
                }
            });
 
    return true;
}
 ...     
 ```