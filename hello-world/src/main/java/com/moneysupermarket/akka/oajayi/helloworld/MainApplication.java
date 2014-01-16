package com.moneysupermarket.akka.oajayi.helloworld;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.moneysupermarket.akka.oajayi.helloworld.actor.GreeterActor;
import com.moneysupermarket.akka.oajayi.helloworld.actor.HelloWorldActor;
import com.moneysupermarket.akka.oajayi.helloworld.model.MyMessage;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 16/01/14
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class MainApplication {


    public static void main(String[] args) {

        ActorSystem rootSystem = ActorSystem.create("MySystem");
        ActorRef greeterRef = rootSystem.actorOf(GreeterActor.mkProps("Greeter"), "GreeterA");
        ActorRef helloWorldRef = rootSystem.actorOf(HelloWorldActor.mkProps("HelloWorld", greeterRef), "HelloWorldActorA");

        helloWorldRef.tell(MyMessage.HELLO, ActorRef.noSender());

        helloWorldRef.tell(MyMessage.INFO, ActorRef.noSender());

        helloWorldRef.tell(MyMessage.GOODBYE, ActorRef.noSender());

    }
}
