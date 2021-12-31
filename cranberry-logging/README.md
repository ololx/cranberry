# cranberry logging

The cranberry statement is a module of cranberry library (see [Cranberry](../README.md)). This module provides an api for the checking statements (such as not null and e.t.c.). This module includes an annotations for the injecting methods of this api into code during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

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