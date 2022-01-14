# cranberry statement

The cranberry statement is a module of cranberry library (see [Cranberry](../README.md)). This module provides an api for the checking statements (such as not null and e.t.c.). This module includes an annotations for the injecting methods of this api into code during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

### Using

#### Using @NotNull

@NotNull can be used as a constraint verifier of a local variable or parameter. The local variable or parameter will be checked against the `NotNUll` constraint (assertion) and will throw an exception if the check fails. This function only works with local variables and parameters.

##### With Cranberry
 ```java
package io.github.ololx.cranberry.examples;

import io.github.ololx.cranberry.statement.annotation.NotNull;

public final class NotNullExamples {

    public int notNullLocalVariableExample(Integer number) {
        @NotNull
        Integer notNullLocalVariable = number;

        return notNullLocalVariable;
    }

    public int notNullMethodParamExample(@NotNull(message = "The notNullMethodParam value is null, Bro") Integer notNullMethodParam) {
        return notNullMethodParam;
    }
}
 ```

##### Without Cranberry

 ```java
package io.github.ololx.cranberry.examples;

import io.github.ololx.cranberry.statement.annotation.NotNull;

public final class NotNullExamples {

    public int notNullLocalVariableExample(Integer number) {
        Integer notNullLocalVariable = number;
        if (notNullLocalVariable == null) {
            throw new NotNullStatementException("'Not null' is expected but actually was 'null'");
        }

        return notNullLocalVariable;
    }

    public int notNullMethodParamExample(Integer notNullMethodParam) {
        if (notNullMethodParam == null) {
            throw new NotNullStatementException("The notNullMethodParam value is null, Bro");
        }
    
        return notNullMethodParam;
    }
}
 ```
 
#### Using @NotEmpty

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
