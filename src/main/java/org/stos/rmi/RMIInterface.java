package org.stos.rmi;

import org.stos.rmi.trxobjects.TheThing;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    public String helloTo(String name) throws RemoteException;

    public TheThing sendTheThing() throws RemoteException;

}
