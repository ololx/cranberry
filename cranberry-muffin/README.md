# cranberry muffin

The cranberry muffin is a module of cranberry library (see [cranberry](../README.md)) and also java library is designed to combine the possibilities of thematically grouped modules into one common library.

Please, visit the project main [page](../README.md) for getting more information about contributing, versioning, licensing and e.t.c.

### Using

The simple example below presents the the checking of a parameters on `not null` value without the specific exception message returns and  `not blank` value with the specific exception message returns.

```java
 ...
//Add the checking statements for method params
public List<SomeDetail> findSomeDetailbyUidAndTypeCode(@NotNull Long uid, 
    @NotEmpty("The Type Code must be not empty") String typeCode) {
    return Collections.EMPTY_LIST;
}
...
```