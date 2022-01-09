# cranberry data

The cranberry data is a module of cranberry library (see [Cranberry](../README.md)). This module provides an api for the java data manipulations: varianbles modifiers, default values, e.t.c. This module includes an annotations for the injecting methods of this api into code during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

### Using

 ```java
 ...
/**
 * The example of {@code @Final} annotation usage on {@code List<String> param}.
 * <p>
 * When this method is called, the parameters will be final;
 */
public static void runWithCustomMessage(@Final List<String> param) {
    ...
}
...
 ```

 ```java
 ...
/**
 * The example of {@code @Final} annotation usage on {@code List<String> variable}.
 * <p>
 * When this method is called, the variable will be final;
 */
public static void runWithCustomMessage(List<String> param) {
   @Final List<String> valuable = param;
}
...
 ```