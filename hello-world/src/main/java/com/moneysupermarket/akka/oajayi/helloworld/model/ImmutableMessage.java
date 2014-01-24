package com.moneysupermarket.akka.oajayi.helloworld.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 17/01/14
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */
public class ImmutableMessage {
    private final int sequenceNumber;
    private final List<String> values;

    private ImmutableMessage(int sequenceNumber, List<String> values) {
       this.sequenceNumber = sequenceNumber;
       this.values = values;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public List<String> getValues() {
        return values;
    }
}
