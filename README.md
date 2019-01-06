# quartz-easy
Quartz Scheduler integration in Spring Boot Framework

The purpose of this project is to simplify the quartz scheduler integration in spring boot framework. I came up with this while setting up quartz scheduler in one of the projects at work.

## How to use
1. Annotate your Job implementation with QJob annotatation with required configuration by setting suitable fields present in the annotation.
```
@QJob(interval="5", intervalType=JobConfig.IntervalType.SEC)
class TestJob implements Job {
    //...
}
```
2. And you are done! **No need** to define factories, JobDetail, Triggers...etc.

## Contribute
Lets make this more simpler and effective! Looking forward to PRs. :smile::+1:
