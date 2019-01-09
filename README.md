# quartz-easy
Quartz Scheduler integration in Spring Boot Framework

The purpose of this project is to simplify the quartz scheduler integration in spring boot framework. I came up with this while setting up quartz scheduler in one of the projects at work.

## How to use
1. Annotate your Job implementation with `Scheduled` annotatation with required configuration by setting suitable fields present in the annotation.
```
import com.indusnode.quartz.annotation.Scheduled;
...
@Scheduled(interval="5", intervalType=JobConfig.IntervalType.SEC)
class TestJob implements Job {
    //...
}
```
2. set application property `qe.base-package` as your base package name of the project which will contain all your job implementations.
3. And you are done! **No need** to define factories, JobDetail, Triggers...etc.

## Contribute
Lets make this more simpler and effective! Looking forward to PRs. :smile::+1:
