Java - Embedded MongoDB
=======================

This is an example project illustrating the usage of
the embedded mongodb provided by "flapdoodle".

Starting Point
--------------

A simple gradle project - copied from
[Github - java-example-springboot-hello-world](https://github.com/uli-heller/java-example-springboot-hello-world).

```
./gradlew wrapper --gradle-version latest
./gradlew wrapper --gradle-version latest
./gradlew --console=plain build
```

Using Some Spring Mechanisms
----------------------------

- src/main/java/Main.java -> src/main/java/com/example/Application.java
- src/main/java/com/example/Main.java
- src/main/java/com/example/UliBean.java
- src/main/java/com/example/UliBeanImpl.java
- src/main/resources/application.properties (to activate debugging)
- src/main/resources/logback-spring.xml (to log into a file)
- build.gradle

Creating JUnit Tests
--------------------


Transformation To MongoDB Project
---------------------------------

build.gradle:

```diff
diff --git a/build.gradle b/build.gradle
index 2a32547..b1a7752 100644
--- a/build.gradle
+++ b/build.gradle
@@ -21,4 +21,6 @@ repositories {
 
 dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-web'
+       implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
+       testImplementation 'de.flapdoodle.embed:de.flapdoodle.embed.mongo.spring3x:4.20.0'
 }
```

Links
-----

- [Github - flapdoodle-oss - Spring3 HowTo.md](https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo.spring/blob/spring-3.x.x/HowTo.md)

History
-------

- 2025-05-28 - Initial version
