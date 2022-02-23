package com.jsanin;

import io.temporal.workflow.WorkflowMethod;
import io.temporal.workflow.WorkflowInterface;

@WorkflowInterface
public interface HelloWorldWorkFlowI {
    @WorkflowMethod
    String executeWorkFlow();
}
