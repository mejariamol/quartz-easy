# quartz-easy
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.indusnode/quartz-easy/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.indusnode/quartz-easy)

Quartz Scheduler integration in Spring Boot Framework

The purpose of this project is to simplify the quartz scheduler integration in spring boot framework. I came up with this while setting up quartz scheduler in one of the projects at work.

## How to use
1. Annotate your Job implementation with `Scheduled` annotation with required configuration by setting suitable fields present in the annotation.
```
import com.indusnode.quartz.annotation.Scheduled;
...
@Scheduled(interval="5", intervalType=Scheduled.IntervalType.SEC)
class TestJob implements Job {
    //...
}
```
2. set application property `qe.base-package` as your base package name of the project which will contain all your job implementations.
3. And you are done! **No need** to define factories, JobDetail, Triggers...etc.

## Installation
#### Maven
In a Maven project, include the `quartz-easy` artifact in the dependencies section of your `pom.xml`
```
<dependency>
  <groupId>com.indusnode</groupId>
  <artifactId>quartz-easy</artifactId>
  <version>1.0.0</version>
</dependency>
```

#### Java Gradle
```
implementation 'com.indusnode:quartz-easy:1.0.0'
```

#### For other build systems please refer [Maven Central Repository](https://search.maven.org/artifact/com.indusnode/quartz-easy/1.0.0/jar).

#### Download
If you do not use maven, gradle, ivy, or other build systems that consume
maven-style binary artifacts, they can be downloaded directly via the
[Maven Central Repository](https://search.maven.org/artifact/com.indusnode/quartz-easy/1.0.0/jar).

## Contribute
Lets make this more simpler and effective! Looking forward to PRs. :smile::+1:
