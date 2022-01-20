# Cranberry Logging

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
The Cranberry Logging          
```

The cranberry loging is a module of cranberry library. This module provides an api for the loggint method params. This module includes an annotations for the injecting methods of this api into code during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

## `@LogParam`

The `@LogParam` annotation could be used as an injection of a `log.info` method execution for each param of the method. A parameter will be printed in log. This annotation only works with some method.

#### With Cranberry
 ```java
package io.github.ololx.cranberry.examples.logging;

import io.github.ololx.cranberry.logging.annotation.LogParam;

import java.util.List;

public final class LogParamMethodExamples {

    @LogParam
    public void logParamMethodDefaultExample(String str, Integer num, List<Object> list) {
        return;
    }

    @LogParam(message = "Bro, you've got a param = ")
    public void logParamMethodCustomMessageExample(String str, Integer num, List<Object> list) {
        return;
    }
}
 ```

#### Without Cranberry

 ```java
 package io.github.ololx.cranberry.examples.logging;

import io.github.ololx.cranberry.logging.annotation.LogParam;

import java.util.List;

public final class LogParamMethodExamples {

    public void logParamMethodDefaultExample(String str, Integer num, List<Object> list) {
        final Logger log = Logger.getLogger(this.getClass().getName());
        log.info("str = " + str);
        log.info("num = " + num);
        log.info("list = " + list);
        
        return;
    }

    public void logParamMethodCustomMessageExample(String str, Integer num, List<Object> list) {
        final Logger log = Logger.getLogger(this.getClass().getName());
        log.info("Bro, you've got a param = " + str);
        log.info("Bro, you've got a param = " + num);
        log.info("Bro, you've got a param = " + list);
        
        return;
    }
}
```
