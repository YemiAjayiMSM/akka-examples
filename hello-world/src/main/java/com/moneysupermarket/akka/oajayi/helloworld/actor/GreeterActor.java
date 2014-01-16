package com.moneysupermarket.akka.oajayi.helloworld.actor;

import akka.actor.Props;
import akka.actor.UntypedActor;
import com.moneysupermarket.akka.oajayi.helloworld.model.MyMessage;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 16/01/14
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */
public class GreeterActor extends UntypedActor{

    private final String name;

    public static Props mkProps(String name) {
        return Props.create(GreeterActor.class, name);
    }

    public GreeterActor(String name) {
        this.name = name;
    }

    @Override
    public void onReceive(Object msg) throws Exception {

        if(msg == MyMessage.HELLO) {

            System.out.println("Hello I'm a greeter!!");

            waitForTimeInSeconds(5);

            System.out.println("Tell sender about receipt of message");

            getSender().tell(MyMessage.RECEIVED, self());

        } else if (msg == MyMessage.INFO) {

            System.out.println("Just for info!!!");

        } else
            unhandled(msg);

    }

    private void waitForTimeInSeconds(int seconds) {

        try {

            TimeUnit.SECONDS.sleep(seconds);

        } catch (InterruptedException ex) {

            System.out.println(ex.getMessage());

        }

    }
}
