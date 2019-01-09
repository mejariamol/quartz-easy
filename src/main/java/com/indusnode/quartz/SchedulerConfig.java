package com.indusnode.quartz;

import com.indusnode.quartz.annotation.Scheduled;
import com.indusnode.quartz.exceptions.QePropertyMissingException;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.StringUtils;

@Configuration
public class SchedulerConfig {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);

    /**
     * All the jobs annotated with {@link Scheduled}
     * are searched and scheduled on this scheduler with required trigger as per the
     * specified intervals in Scheduled annotation declaration.
     */
    @Bean
    public Scheduler scheduler(@Value("${qe.base-package}") String basePackage) throws SchedulerException, QePropertyMissingException {
        if (basePackage == null || StringUtils.isEmpty(basePackage)) {
            logger.error("'qe.base-package' property missing. Please define this property with value of base package of " +
                    "your project where all the jobs are defined.");
            throw new QePropertyMissingException("qe.base-package property missing");
        }
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        // schedule all the jobs with suitable triggers here
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Scheduled.class));

        JobDetail jobDetail;
        Trigger trigger;
        for (BeanDefinition bdf : provider.findCandidateComponents(basePackage)) {
            try {
                Class cl = Class.forName(bdf.getBeanClassName());
                jobDetail = JobBuilder.newJob(cl).storeDurably().build();
                Scheduled config = (Scheduled) cl.getAnnotation(Scheduled.class);

                // TODO: Check the interval type and create scheduleBuilder accordingly
                SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(Integer.parseInt(config.interval()))
                        .repeatForever();
                trigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } catch (ClassNotFoundException ignored) {}
        }
        return scheduler;
    }
}
