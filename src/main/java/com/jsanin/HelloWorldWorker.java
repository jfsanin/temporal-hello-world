package com.jsanin;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class HelloWorldWorker {
    public static void main(String[] args) {
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        WorkflowClient client = WorkflowClient.newInstance(service);

        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(HelloWorldConstants.FLOW_QUEUE_NAME);

        worker.registerWorkflowImplementationTypes(HelloWorldWorkFlow.class);

        worker.registerActivitiesImplementations(new DateInfoActivity());

        factory.start();
    }
}
