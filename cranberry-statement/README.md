# Cranberry Statement

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
The Cranberry Statement          
```

The cranberry statement is a module of cranberry library. This module provides an api for the checking statements (such as not null and e.t.c.). This module includes an annotations for the injecting methods of this api into code during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

## `@NotNull`

The `@NotNull` annotation could be used as a constraint verifier of a local variable or parameter. The local variable or parameter will be checked against the `not null` constraint (assertion) and will throw an exception if the check fails. This annotation only works with local variables and parameters.

### Local variables

The `@NotNull` annotation could be used for a state on local variables. 

#### With Cranberry
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

#### Without Cranberry

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

### Method params

The `@NotNull` annotation could be used for a state on method params. 

#### With Cranberry

```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotNull;

public final class NotNullMethodParamExamples {

    public Object notNullObjectParamDefaultExample(@NotNull Object notNullMethodParam) {
        return notNullMethodParam;
    }

    public Object notNullObjectParamCustomMessageExample(
            @NotNull(message = "The param is empty, Bro =)") Object notNullMethodParam) {
        return notNullMethodParam;
    }
}
```

#### Without Cranberry

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
            throw new NotNullStatementException("The param is empty, Bro =)");
        }
        
        return notNullMethodParam;
    }
}
 ```

## `@NotEmpty`

The `@NotEmpty` annotation can be used as a constraint verifier of a local variable or parameter. The local variable or parameter will be checked against the `NotEmpty` constraint (assertion) and will throw an exception if the check fails. This function only works with local variables and parameters.

### Local variables

The `@NotEmpty` annotation could be used for a state on local variables. 

#### With Cranberry
 ```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotEmpty;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotEmptyLocalVariableExamples {

    public String notEmptyStringVariableDefaultExample(String str) {
        @NotEmpty String notEmptyLocalVariable = str;

        return notEmptyLocalVariable;
    }

    public String notEmptyStringVariableCustomMessageExample(String str) {
        @NotEmpty(message = "The variable is empty, Bro =)")
        String notEmptyLocalVariable = str;

        return notEmptyLocalVariable;
    }

    public List<String> notEmptyListVariableDefaultExample(List<String> list) {
        @NotEmpty List<String> notEmptyLocalVariable = list;

        return notEmptyLocalVariable;
    }

    public List<String> notEmptyListVariableCustomMessageExample(List<String> list) {
        @NotEmpty(message = "The variable is empty, Bro =)")
        List<String> notEmptyLocalVariable = list;

        return notEmptyLocalVariable;
    }

    public Set<String> notEmptySetVariableDefaultExample(Set<String> set) {
        @NotEmpty Set<String> notEmptyLocalVariable = set;

        return notEmptyLocalVariable;
    }

    public Set<String> notEmptySetVariableCustomMessageExample(Set<String> set) {
        @NotEmpty(message = "The variable is empty, Bro =)")
        Set<String> notEmptyLocalVariable = set;

        return notEmptyLocalVariable;
    }

    public Map<String, String> notEmptyMapVariableDefaultExample(Map<String, String> map) {
        @NotEmpty Map<String, String> notEmptyLocalVariable = map;

        return notEmptyLocalVariable;
    }

    public Map<String, String> notEmptyMapVariableCustomMessageExample(Map<String, String> map) {
        @NotEmpty(message = "The variable is empty, Bro =)")
        Map<String, String> notEmptyLocalVariable = map;

        return notEmptyLocalVariable;
    }

    public String[] notEmptyArrayVariableDefaultExample(String[] array) {
        @NotEmpty String[] notEmptyLocalVariable = array;

        return notEmptyLocalVariable;
    }

    public String[] notEmptyArrayVariableCustomMessageExample(String[] array) {
        @NotEmpty(message = "The variable is empty, Bro =)")
        String[] notEmptyLocalVariable = array;

        return notEmptyLocalVariable;
    }
}
 ```

#### Without Cranberry

```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotEmpty;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotEmptyLocalVariableExamples {

    public String notEmptyStringVariableDefaultExample(String str) {
        String notEmptyLocalVariable = str;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.length() == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }

        return notEmptyLocalVariable;
    }

    public String notEmptyStringVariableCustomMessageExample(String str) {
        String notEmptyLocalVariable = str;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.length() == 0) {
            throw new NotEmptyStatementException("The variable is empty, Bro =)");
        }

        return notEmptyLocalVariable;
    }

    public List<String> notEmptyListVariableDefaultExample(List<String> list) {
        List<String> notEmptyLocalVariable = list;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }

        return notEmptyLocalVariable;
    }

    public List<String> notEmptyListVariableCustomMessageExample(List<String> list) {
        List<String> notEmptyLocalVariable = list;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("The variable is empty, Bro =)");
        }

        return notEmptyLocalVariable;
    }

    public Set<String> notEmptySetVariableDefaultExample(Set<String> set) {
        Set<String> notEmptyLocalVariable = set;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }

        return notEmptyLocalVariable;
    }

    public Set<String> notEmptySetVariableCustomMessageExample(Set<String> set) {
        Set<String> notEmptyLocalVariable = set;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("The variable is empty, Bro =)");
        }

        return notEmptyLocalVariable;
    }

    public Map<String, String> notEmptyMapVariableDefaultExample(Map<String, String> map) {
        Map<String, String> notEmptyLocalVariable = map;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }

        return notEmptyLocalVariable;
    }

    public Map<String, String> notEmptyMapVariableCustomMessageExample(Map<String, String> map) {
        Map<String, String> notEmptyLocalVariable = map;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.size() == 0) {
            throw new NotEmptyStatementException("The variable is empty, Bro =)");
        }

        return notEmptyLocalVariable;
    }

    public String[] notEmptyArrayVariableDefaultExample(String[] array) {
        String[] notEmptyLocalVariable = array;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.length == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }

        return notEmptyLocalVariable;
    }

    public String[] notEmptyArrayVariableCustomMessageExample(String[] array) {
        String[] notEmptyLocalVariable = array;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.length == 0) {
            throw new NotEmptyStatementException("The variable is empty, Bro =)");
        }

        return notEmptyLocalVariable;
    }
}
 ```

### Method params

The `@NotEmpty` annotation could be used for a state on method params.

#### With Cranberry
 ```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotEmpty;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotEmptyMethodParamExamples {

    public String notEmptyStringParamDefaultExample(
            @NotEmpty String notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public String notEmptyStringParamCustomMessageExample(
            @NotEmpty(message = "The param is empty, Bro =)") String notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public List<String> notEmptyListParamDefaultExample(
            @NotEmpty List<String> notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public List<String> notEmptyListParamCustomMessageExample(
            @NotEmpty(message = "The param is empty, Bro =)") List<String> notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public Set<String> notEmptySetParamDefaultExample(
            @NotEmpty Set<String> notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public Set<String> notEmptySetParamCustomMessageExample(
            @NotEmpty(message = "The param is empty, Bro =)") Set<String> notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public Map<String, Map> notEmptyMapParamDefaultExample(
            @NotEmpty Map<String, Map> notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public Map<String, Map> notEmptyMapParamCustomMessageExample(
            @NotEmpty(message = "The param is empty, Bro =)") Map<String, Map> notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public String[] notEmptyArrayParamDefaultExample(
            @NotEmpty String[] notEmptyMethodParam) {
        return notEmptyMethodParam;
    }

    public String[] notEmptyArrayParamCustomMessageExample(
            @NotEmpty(message = "The param is empty, Bro =)") String[] notEmptyMethodParam) {
        return notEmptyMethodParam;
    }
}
 ```

#### Without Cranberry

```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotEmpty;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotEmptyLocalVariableExamples {

    public String notEmptyStringVariableDefaultExample(String str) {
        String notEmptyLocalVariable = str;
        if (notEmptyLocalVariable == null || notEmptyLocalVariable.length() == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }

        return notEmptyLocalVariable;
    }

package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotEmpty;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotEmptyMethodParamExamples {

    public String notEmptyStringParamDefaultExample(String notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.length() == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }
        
        return notEmptyMethodParam;
    }

    public String notEmptyStringParamCustomMessageExample(String notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.length() == 0) {
            throw new NotEmptyStatementException("The param is empty, Bro =)");
        }
        
        return notEmptyMethodParam;
    }

    public List<String> notEmptyListParamDefaultExample(List<String> notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.size() == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }
        
        return notEmptyMethodParam;
    }

    public List<String> notEmptyListParamCustomMessageExample(List<String> notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.size() == 0) {
            throw new NotEmptyStatementException("The param is empty, Bro =)");
        } 
    
        return notEmptyMethodParam;
    }

    public Set<String> notEmptySetParamDefaultExample(Set<String> notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.size() == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }
    
        return notEmptyMethodParam;
    }

    public Set<String> notEmptySetParamCustomMessageExample(Set<String> notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.size() == 0) {
            throw new NotEmptyStatementException("The param is empty, Bro =)");
        } 
    
        return notEmptyMethodParam;
    }

    public Map<String, Map> notEmptyMapParamDefaultExample(Map<String, Map> notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.size() == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }
    
        return notEmptyMethodParam;
    }

    public Map<String, Map> notEmptyMapParamCustomMessageExample(Map<String, Map> notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.size() == 0) {
            throw new NotEmptyStatementException("The param is empty, Bro =)");
        } 
    
        return notEmptyMethodParam;
    }

    public String[] notEmptyArrayParamDefaultExample(String[] notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.length == 0) {
            throw new NotEmptyStatementException("'Not empty' is expected but actually was '" + notEmptyLocalVariable + "'");
        }
    
        return notEmptyMethodParam;
    }

    public String[] notEmptyArrayParamCustomMessageExample(String[] notEmptyMethodParam) {
        if (notEmptyMethodParam == null || notEmptyMethodParam.length == 0) {
            throw new NotEmptyStatementException("The param is empty, Bro =)");
        }    
            
        return notEmptyMethodParam;
    }
}    
 ```
 
 ## `@NotBlank`

The `@NotBlank` annotation could be used as a constraint verifier of a local variable or parameter. The local variable or parameter will be checked against the `not blank` constraint (assertion) and will throw an exception if the check fails. This annotation only works with local variables and parameters.

### Local variables

The `@NotBlank` annotation could be used for a state on local variables. 

#### With Cranberry
 ```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotBlank;

public final class NotBlankLocalVariableExamples {

    public String notBlankStringVariableDefaultExample(String str) {
        @NotBlank String notBlankLocalVariable = str;

        return notBlankLocalVariable;
    }

    public String notBlankStringVariableCustomMessageExample(String str) {
        @NotBlank(message = "The variable is blank, Bro =)")
        String notBlankLocalVariable = str;

        return notBlankLocalVariable;
    }
}
 ```

#### Without Cranberry

 ```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotBlank;

public final class NotBlankLocalVariableExamples {

    public String notBlankStringVariableDefaultExample(String str) {
        String notBlankLocalVariable = str;
        if (notBlankLocalVariable == null) {
            throw new NotNullStatementException("'Not blank' is expected but actually was '" + notBlankLocalVariable + "'");
        }

        return notBlankLocalVariable;
    }

    public String notBlankStringVariableCustomMessageExample(String str) {
        String notBlankLocalVariable = str;
        if (notBlankLocalVariable == null) {
            throw new NotNullStatementException("The variable is blank, Bro =)");
        }

        return notBlankLocalVariable;
    }
}
```

### Method params

The `@NotBlank` annotation could be used for a state on method params. 

#### With Cranberry

```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotBlank;

public final class NotBlankMethodParamExamples {

    public String notBlankStringParamDefaultExample(@NotBlank String notBlankMethodParam) {
        return notBlankMethodParam;
    }

    public String notBlankStringParamCustomMessageExample(
            @NotBlank(message = "The param is blank, Bro =)") String notBlankMethodParam) {
        return notBlankMethodParam;
    }
}
```

#### Without Cranberry

```java
package io.github.ololx.cranberry.examples.statement;

import io.github.ololx.cranberry.statement.annotation.NotBlank;

public final class NotBlankMethodParamExamples {

    public String notBlankStringParamDefaultExample(String notBlankMethodParam) {
        if (notNullMethodParam == null) {
            throw new NotNullStatementException("'Not blank' is expected but actually was '" + notBlankMethodParam + "'");
        }
        
        return notBlankMethodParam;
    }

    public String notBlankStringParamCustomMessageExample(String notBlankMethodParam) {
        if (notNullMethodParam == null) {
            throw new NotNullStatementException("The param is blank, Bro =)");
        }
        
        return notBlankMethodParam;
    }
}
 ```
