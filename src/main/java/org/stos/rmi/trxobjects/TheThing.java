package org.stos.rmi.trxobjects;

import java.io.Serializable;

public class TheThing implements Serializable{
    private int id;
    private String name;
    private InternalThing internalThing;

    public TheThing(int id, String name, InternalThing internalThing) {
        this.id = id;
        this.name = name;
        this.internalThing = internalThing;
    }

    @Override
    public String toString() {
        return "I am a thing with id:" + id + " and name: " + name + ". My internal thnig says: "
                + internalThing.toString();
    }
}
