# cranberry statement

The cranberry statement is a module of cranberry library (see [Cranberry](../README.md)). This module provides an api for the checking statements (such as not null and e.t.c.). This module includes an annotations for the injecting methods of this api into code during compilation.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

### Using

 ```java
 ...
//Add the checking statements for method params
public List<SomeDetail> findSomeDetailbyUidAndTypeCode(@NotNull Long uid, 
    @NotEmpty("Type Code must be not empty") String typeCode) {
    return this.getArtefacts(processingArtefactRepository.selectAllWorkingForSurvey(uidSurvey, typeCode));
}
...
 ```

 ```java
 ...
//Add the checking statements for method variables
public List<SomeDetail> findSomeDetailbyUidAndTypeCode(Long uid, String typeCode) {
   @NotEmpty("The Code must be not empty") String code = typeCode;
  
   return this.getArtefacts(processingArtefactRepository.selectAllWorkingForSurvey(uidSurvey, typeCode));
}
...
 ```