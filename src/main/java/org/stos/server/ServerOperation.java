package org.stos.server;

import org.stos.rmi.RMIInterface;
import org.stos.rmi.trxobjects.InternalThing;
import org.stos.rmi.trxobjects.TheThing;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUiD = 1L;

    protected ServerOperation(RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(2020, csf, ssf);
    }

    @Override
    public String helloTo(String name) {
        System.out.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }

    @Override
    public TheThing sendTheThing() {
        System.out.println("Preparing The Thing!");
        InternalThing iT = new InternalThing("cervantes", "I thing therefore I thang!");
        TheThing tT = new TheThing(1337, "DA-THANG", iT);
        return tT;
    }
}
