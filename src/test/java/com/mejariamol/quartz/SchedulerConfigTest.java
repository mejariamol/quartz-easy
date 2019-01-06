package com.mejariamol.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Scheduler;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// TODO: write suitable tests

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SchedulerConfig.class, Scheduler.class})
public class SchedulerConfigTest {

    @Test
    public void contextTest() {}
}
