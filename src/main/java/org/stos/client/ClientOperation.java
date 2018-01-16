package org.stos.client;

import org.stos.rmi.RMIInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientOperation {
    private static RMIInterface lookUp;

    ClientOperation() throws RemoteException, NotBoundException, MalformedURLException {
        lookUp = (RMIInterface) Naming.lookup("//localhost/TheServer");
    }

    public RMIInterface lookUpServer() {
        return lookUp;
    }
}
