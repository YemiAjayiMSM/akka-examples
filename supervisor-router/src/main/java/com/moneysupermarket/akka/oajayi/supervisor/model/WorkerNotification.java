package com.moneysupermarket.akka.oajayi.supervisor.model;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 24/01/14
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class WorkerNotification {

    private final StatusMessage message;
    private final int workerId;

    public WorkerNotification(StatusMessage message, int workerId){
        this.message = message;
        this.workerId = workerId;
    }

    public StatusMessage getMessage() {
        return message;
    }

    public int getWorkerId() {
        return workerId;
    }
}
