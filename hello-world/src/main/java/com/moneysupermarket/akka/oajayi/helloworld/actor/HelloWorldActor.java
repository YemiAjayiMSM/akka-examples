package com.moneysupermarket.akka.oajayi.helloworld.actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.moneysupermarket.akka.oajayi.helloworld.model.MyMessage;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 16/01/14
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldActor extends UntypedActor{

    LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    private final String name;
    private final ActorRef greeterRef;

    public static Props mkProps(String name, ActorRef greeterRef){
        return Props.create(HelloWorldActor.class, name, greeterRef);
    }

    public HelloWorldActor(String name, ActorRef greeterRef) {
        this.name = name;
        this.greeterRef = greeterRef;
    }
    
    @Override
    public void onReceive(Object msg) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.

        if (msg == MyMessage.HELLO) {
            logger.info("Sending Hello to Greeter");
            greeterRef.tell(msg, self());


        } else if(msg == MyMessage.RECEIVED){

            logger.info("Response received from Greeter");

        } else if (msg == MyMessage.GOODBYE) {

            //logger.info("Received Message: {}", msg);
            System.out.println("Goodbye!!");
            getContext().system().shutdown();

        } else
            unhandled(msg);

    }
}
