package com.moneysupermarket.akka.oajayi.supervisor.actor;

import akka.actor.Props;
import akka.actor.UntypedActor;
import com.moneysupermarket.akka.oajayi.supervisor.model.ImmutableMessage;
import com.moneysupermarket.akka.oajayi.supervisor.model.StatusMessage;
import com.moneysupermarket.akka.oajayi.supervisor.model.WorkerNotification;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 17/01/14
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public class WorkerActor extends UntypedActor{

    public static Props mkProps(){
        return Props.create(WorkerActor.class);
    }

    @Override
    public void onReceive(Object msg) throws Exception {

        if(msg instanceof WorkerNotification){

            WorkerNotification notification = (WorkerNotification)msg;

            if(notification.getMessage() == StatusMessage.STARTING){

                int workerId = notification.getWorkerId();

                System.out.println(String.format("Worker #%d: Doing Something!!", workerId));

                getSender().tell(new WorkerNotification(StatusMessage.DONE, workerId), getSelf());
            }

        }
        else
            unhandled(msg);

    }

    @Override
    public void postStop() throws Exception {

        System.out.println("Shutting down ChildWorker");

    }
}
