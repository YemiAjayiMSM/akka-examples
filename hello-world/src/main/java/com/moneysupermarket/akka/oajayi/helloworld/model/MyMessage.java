package com.moneysupermarket.akka.oajayi.helloworld.model;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 15/01/14
 * Time: 17:56
 * To change this template use File | Settings | File Templates.
 */
public enum MyMessage {
    HELLO("Hello"),
    RECEIVED("Received"),
    INFO("Info"),
    GOODBYE("Goodbye");

    private String nameAsString;

    private MyMessage(String nameAsString) {
        this.nameAsString = nameAsString;
    }

    @Override
    public String toString() {
        return this.nameAsString;
    }
}
