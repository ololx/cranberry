# cranberry statement

The cranberry statement is a module of cranberry library (see [Cranberry](../README.md)). This module provides an api for the checking statements (such as not null and e.t.c.). This module includes an annotations for the injecting methods of this api into code during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

## Using

### @NotNull

`@NotNull` can be used as a constraint verifier of a local variable or parameter. The local variable or parameter will be checked against the `NotNUll` constraint (assertion) and will throw an exception if the check fails. This function only works with local variables and parameters.

#### For local variables

The `@NotNull` annotation could be used for a state on local variables. 

##### With Cranberry
 ```java
import io.github.ololx.cranberry.statement.annotation.NotNull;

public final class NotNullLocalVariableExamples {

    public Object notNullObjectVariableDefaultExample(Object object) {
        @NotNull
        Object notNullLocalVariable = object;

        return notNullLocalVariable;
    }

    public Object notNullObjectVariableCustomMessageExample(Object object) {
        @NotNull(message = "The variable is empty, Bro =)")
        Object notNullLocalVariable = object;

        return notNullLocalVariable;
    }
}
 ```

##### Without Cranberry

 ```java
 import io.github.ololx.cranberry.statement.annotation.NotNull;

public final class NotNullLocalVariableExamples {

    public Object notNullObjectVariableDefaultExample(Object object) {
        Object notNullLocalVariable = object;
        if (notNullLocalVariable == null) {
            throw new NotNullStatementException("'Not null' is expected but actually was 'null'");
        }

        return notNullLocalVariable;
    }

    public Object notNullObjectVariableCustomMessageExample(Object object) {
        Object notNullLocalVariable = object;
        if (notNullLocalVariable == null) {
            throw new NotNullStatementException("The variable is empty, Bro =)");
        }
        
        return notNullLocalVariable;
    }
}
```

#### For method params

The `@NotNull` annotation could be used for a state on method params. 

##### With Cranberry

```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotNull;

public final class NotNullMethodParamExamples {

    public Object notNullObjectParamDefaultExample(@NotNull Object notNullMethodParam) {
        return notNullMethodParam;
    }

    public Object notNullObjectParamCustomMessageExample(
            @NotNull(message = "The variable is empty, Bro =)") Object notNullMethodParam) {
        return notNullMethodParam;
    }
}
```

##### Without Cranberry

```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotNull;

public final class NotNullMethodParamExamples {

    public Object notNullObjectParamDefaultExample(Object notNullMethodParam) {
        if (notNullMethodParam == null) {
            throw new NotNullStatementException("'Not null' is expected but actually was 'null'");
        }
        
        return notNullMethodParam;
    }

    public Object notNullObjectParamCustomMessageExample(Object notNullMethodParam) {
        if (notNullMethodParam == null) {
            throw new NotNullStatementException("The variable is empty, Bro =)");
        }
        
        return notNullMethodParam;
    }
}
 ```
 
### Using @NotEmpty

@NotEmpty can be used as a constraint verifier of a local variable or parameter. The local variable or parameter will be checked against the `NotEmpty` constraint (assertion) and will throw an exception if the check fails. This function only works with local variables and parameters.

##### With Cranberry
 ```java
import io.github.ololx.cranberry.statement.annotation.NotEmpty;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotEmptyExamples {

    public String notEmptyLocalVariableExample(String str) {
        @NotEmpty(message = "The notEmptyLocalVariable value is empty, Bro")
        String notEmptyLocalVariable = str;

        return notEmptyLocalVariable;
    }

    public List<String> notEmptyLocalVariableExample(List<String> list) {
        @NotEmpty(message = "The notEmptyLocalVariable value is empty, Bro")
        List<String> notEmptyLocalVariable = list;

        return notEmptyLocalVariable;
    }

    public Set<String> notEmptyLocalVariableExample(Set<String> set) {
        @NotEmpty(message = "The notEmptyLocalVariable value is empty, Bro")
        Set<String> notEmptyLocalVariable = set;

        return notEmptyLocalVariable;
    }

    public Map<String, String> notEmptyLocalVariableExample(Map<String, String> map) {
        @NotEmpty(message = "The notEmptyLocalVariable value is empty, Bro")
        Map<String, String> notEmptyLocalVariable = map;

        return notEmptyLocalVariable;
    }

    public String[] notEmptyLocalVariableExample(String[] array) {
        @NotEmpty(message = "The notEmptyLocalVariable value is empty, Bro")
        String[] notEmptyLocalVariable = array;

        return notEmptyLocalVariable;
    }

    public String notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") String notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public List<String> notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") List<String> notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public Set<String> notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") Set<String> notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public Map<String, Map> notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") Map<String, Map> notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public String[] notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") String[] notEmptyMethodParam) {
        return notEmptyMethodParam;
    }
 }
 ```

##### Without Cranberry

 ```java
package io.github.ololx.cranberry.examples;

import io.github.ololx.cranberry.statement.annotation.NotNull;

public final class NotEmptyExamples {

    public String notEmptyLocalVariableExample(String str) {
        String notEmptyLocalVariable = str;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.length() == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }

        return notEmptyLocalVariable;
    }

    public List<String> notEmptyLocalVariableExample(List<String> list) {
        List<String> notEmptyLocalVariable = list;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }
        
        return notEmptyLocalVariable;
    }

    public Set<String> notEmptyLocalVariableExample(Set<String> set) {
        Set<String> notEmptyLocalVariable = set;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }
        
        return notEmptyLocalVariable;
    }

    public Map<String, String> notEmptyLocalVariableExample(Map<String, String> map) {
        Map<String, String> notEmptyLocalVariable = map;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }
        
        return notEmptyLocalVariable;
    }

    public String[] notEmptyLocalVariableExample(String[] array) {
        String[] notEmptyLocalVariable = array;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.length == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }
        
        return notEmptyLocalVariable;
    }

    public String notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") String notEmptyMethodParam) {
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.length() == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }
        
        return notEmptyMethodParam;
    }

    public List<String> notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") List<String> notEmptyMethodParam) {
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }
        
        return notEmptyMethodParam;
    }

    public Set<String> notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") Set<String> notEmptyMethodParam) {
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }
        
        return notEmptyMethodParam;
    }

    public Map<String, Map> notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") Map<String, Map> notEmptyMethodParam) {
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }
        
        return notEmptyMethodParam;
    }

    public String[] notEmptyMethodParamExample(@NotEmpty(message = "The notEmptyMethodParam value is empty, Bro") String[] notEmptyMethodParam) {
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.length == 0) {
            throw new NotEmptyStatementException("The notEmptyLocalVariable value is empty, Bro");
        }
        
        return notEmptyMethodParam;
    }
}
 ```
