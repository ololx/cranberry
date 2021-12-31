# cranberry commons

The cranberryengine is a module of cranberry library (see [cranberry](../README.md)). This module provides  a general realisation of simple tools and wrappers which are used in another cranberry modules for the automatically 
code generating during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

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