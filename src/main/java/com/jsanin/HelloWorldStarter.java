package com.jsanin;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class HelloWorldStarter {
    public static void main(String[] args) {
        // This gRPC stubs wrapper talks to the local docker instance of the Temporal service.
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        // WorkflowClient can be used to start, signal, query, cancel, and terminate Workflows.
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(HelloWorldConstants.FLOW_QUEUE_NAME)
                .build();
        // WorkflowStubs enable calls to methods as if the Workflow object is local, but actually perform an RPC.
        HelloWorldWorkFlowI workflow = client.newWorkflowStub(HelloWorldWorkFlowI.class, options);
        // Synchronously execute the Workflow and wait for the response.
        String localDate = workflow.executeWorkFlow();
        System.out.println(localDate);
        System.exit(0);
    }
}
