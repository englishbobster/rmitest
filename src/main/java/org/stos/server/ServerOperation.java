package org.stos.server;

import org.stos.rmi.RMIInterface;
import org.stos.rmi.trxobjects.InternalThing;
import org.stos.rmi.trxobjects.TheThing;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUiD = 1L;

    protected ServerOperation() throws RemoteException {
        super(2020, new SslRMIClientSocketFactory(), new SslRMIServerSocketFactory(null, null, true));
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
