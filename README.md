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

Now we see this:

```sh
$ ./gradlew build
$ java -jar build/libs/java-embedded-mongodb-0.0.1-SNAPSHOT.jar
Hello, World!

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.6)

Main - main: Hello, World!
Secret: SECRET!
```

Creating JUnit Tests
--------------------

- build.gradle
- src/test/java/com/example/UliBeanTest.java

Now we see:

```sh
$ ./gradlew test
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended

> Task :test

UliBeanTest > testUliBean() PASSED

BUILD SUCCESSFUL in 2s
5 actionable tasks: 5 executed
```

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

A Test Based On MongoDB
-----------------------

- src/test/java/com/example/SimpleMongoWriterTest.java

```sh
$ OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended

> Task :test

SimpleMongoWriterTest > createCollectionAndCount(MongoTemplate) PASSED

SimpleMongoWriterTest > createCollectionAndWrite(MongoTemplate) PASSED

UliBeanTest > testUliBean() PASSED

BUILD SUCCESSFUL in 4s
5 actionable tasks: 5 executed
```

Note: The test works OK only

- if the mongodb instance is not running
- if the mongodb database storage area is empty (`rm -rf mongodb-dir` - otherwise createCollectionAndWrite() fails with
  expected: 1L but was: 2L)

Examining The MongoDB
---------------------

- Download and install mongodb-linux-x86_64-ubuntu2404-8.0.9.tgz
- Start it by executing `.../mongod --dbpath "$(pwd)/mongodb-dir"`
- Download and install mongodb-compass-1.46.0-linux-x64.tar.gz
- Start it by executing `.../MongoDB\ Compass --no-sandbox`
- Connect to the default db localhost:27017
- The collections are located underneath "test"
  - deleteMe
  - myCollection

Links
-----

- [Github - flapdoodle-oss - Spring3 HowTo.md](https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo.spring/blob/spring-3.x.x/HowTo.md)

History
-------

- 2025-05-28 - Initial version
