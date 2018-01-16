package org.stos.rmi.trxobjects;

import java.io.Serializable;

public class InternalThing implements Serializable{

    private String internalName;
    private String internalDialog;

    public InternalThing(String internalName, String internalDialog) {
        this.internalName = internalName;
        this.internalDialog = internalDialog;
    }

    @Override
    public String toString() {
        return "I am internal thing with name:" + internalName + ". My dialog is:" + internalDialog;
    }
}
