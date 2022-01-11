# cranberry data

The cranberry data is a module of cranberry library (see [Cranberry](../README.md)). This module provides an api for the java data manipulations: varianbles modifiers, default values, e.t.c. This module includes an annotations for the injecting methods of this api into code during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

### Using

#### Using @Final

The @Final could be used as the modifier of a local variable or a param. The local variable or param will be made final. This feature works on local variables and params only.

##### With Cranberry
 ```java
package io.github.cranberry.examples;

import io.github.ololx.cranberry.data.modifier.annotation.Final;

import java.util.Set;

public class FinalExample {

    public int finalLocalVariableExample() {
        @Final Set<Integer> finalLocalVariable = Set.of(1, 2, 3, 4);

        return finalLocalVariable.stream().reduce(Integer::sum).orElse(0);
    }

    public int finalMethodParamExample(@Final Set<Integer> finalMethodParam) {
        return finalMethodParam.stream().reduce(Integer::sum).orElse(0);
    }
}
 ```

##### Without Cranberry

 ```java
package io.github.cranberry.examples;

import java.util.Set;

public class FinalExample {

    public int finalLocalVariableExample() {
        final Set<Integer> finalLocalVariable = Set.of(1, 2, 3, 4);

        return finalLocalVariable.stream().reduce(Integer::sum).orElse(0);
    }

    public int finalMethodParamExample(final Set<Integer> finalMethodParam) {
        return finalMethodParam.stream().reduce(Integer::sum).orElse(0);
    }
}
 ```
