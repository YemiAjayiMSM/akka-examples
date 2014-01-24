package com.moneysupermarket.akka.oajayi.supervisor.model;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 24/01/14
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */
public enum StatusMessage {
    STARTING("Starting"),
    DONE("Done");

    private final String nameAsString;

    private StatusMessage(String nameAsString){
        this.nameAsString = nameAsString;
    }

    @Override
    public String toString() {
        return this.nameAsString;
    }
}
