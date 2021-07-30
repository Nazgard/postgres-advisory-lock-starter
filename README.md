[![](https://jitpack.io/v/Nazgard/postgres-advisory-lock-starter.svg)](https://jitpack.io/#Nazgard/postgres-advisory-lock-starter)

Step 1. Add the JitPack repository to your build file
```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```

Step 2. Add the dependency
```xml
<dependency>
    <groupId>com.github.Nazgard</groupId>
    <artifactId>postgres-advisory-lock-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

Basic usage
```java
@Service
public class SomeBusinessService {
    
    private final AdvisoryLockService advisoryLockService;    
    
    @Transactional //is mandatory for transactional lock
    public void lockById(Long id) {
        advisoryLockService.transactionalLock(id);
    }
}
```
