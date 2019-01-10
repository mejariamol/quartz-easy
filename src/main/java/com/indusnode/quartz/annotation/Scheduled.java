package com.indusnode.quartz.annotation;

import com.indusnode.quartz.SchedulerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the associated class implementing Job {@link org.quartz.Job}
 * shall be scheduled automatically according to the properties provided.
 *
 * The scheduling is automatically done at {@link SchedulerConfig#scheduler(String)} ()}
 * To use the auto scheduling, annotate your Job implementation with this annotation
 * with required properties.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Scheduled {

    String interval() default "";

    // TODO: Keep CRON as default
    IntervalType intervalType() default IntervalType.SEC;

    enum IntervalType {
        CRON,
        SEC,
        HR
    }
}
