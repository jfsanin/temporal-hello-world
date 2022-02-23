package com.jsanin;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.ActivityStub;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class HelloWorldWorkFlow implements HelloWorldWorkFlowI {

    @Override
    public String executeWorkFlow() {
        ActivityOptions activityOptions = ActivityOptions.newBuilder()
                .setScheduleToCloseTimeout(Duration.ofSeconds(2))
                .build();

        final DateInfoActivityI dateInfoActivity = Workflow.newActivityStub(DateInfoActivityI.class, activityOptions);
        return dateInfoActivity.getDate().toString();
    }
}
