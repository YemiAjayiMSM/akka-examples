package com.moneysupermarket.akka.oajayi.supervisor.actor;

import akka.actor.*;
import com.moneysupermarket.akka.oajayi.supervisor.model.ImmutableMessage;
import com.moneysupermarket.akka.oajayi.supervisor.model.StatusMessage;
import com.moneysupermarket.akka.oajayi.supervisor.model.WorkerNotification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 17/01/14
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public class SupervisorActor extends UntypedActor {

    private final int childCount;

    private int completedChildWorkers = 0;

    private List<ActorRef> myWorkers;

    public static Props mkProps(int childCount){
        return Props.create(SupervisorActor.class, childCount);
    }

    public SupervisorActor(int childCount){
        this.childCount = childCount;
    }

    @Override
    public void preStart() throws Exception {

        myWorkers = new ArrayList<ActorRef>();

        for(int idx = 1; idx <= childCount; idx++){

            ActorRef newWorker = getContext().actorOf(WorkerActor.mkProps(), String.format("MyChildWorker%d", idx));
            myWorkers.add(newWorker);
        }

    }

    @Override
    public void onReceive(Object msg) throws Exception {

        if(msg.equals("Do Something!")){

            int workerId = 1;
            for(ActorRef childWorkerRef: myWorkers) {

                WorkerNotification notification = new WorkerNotification(StatusMessage.STARTING, workerId++);

                childWorkerRef.tell(notification, getSelf());
            }

        } else if (msg instanceof WorkerNotification){

            WorkerNotification notification = (WorkerNotification)msg;

            if(notification.getMessage() == StatusMessage.DONE) {

                int workerId = notification.getWorkerId();

                ActorRef senderRef = getSender();

                System.out.printf("Worker #%d is done\n", workerId);

                System.out.println("Shutting down Child Worker " + workerId);

                getContext().watch(senderRef);
                //getContext().stop(senderRef);
                senderRef.tell(PoisonPill.getInstance(), getSelf());
            }
        } else if (msg instanceof Terminated) {

            completedChildWorkers++;

            if(completedChildWorkers == childCount){
                System.out.println("All workers completed. Shutting down System.");

                getContext().system().shutdown();
            }
        }
        else
            unhandled(msg);

    }
}
