package com.moneysupermarket.akka.oajayi.supervisor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.moneysupermarket.akka.oajayi.supervisor.actor.SupervisorActor;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 22/01/14
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */
public class MainApplication {

    public static void main(String[] args) {

        ActorSystem system_root = ActorSystem.create("RootSystem");
        ActorRef supervisor = system_root.actorOf(SupervisorActor.mkProps(5), "Supervisor");

        supervisor.tell("Do Something!", ActorRef.noSender());

        //ActorSystem.

    }

}
