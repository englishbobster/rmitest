package org.stos.client;

import org.stos.rmi.RMIInterface;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientOperation {
    private static RMIInterface lookUp;

    ClientOperation() throws RemoteException, NotBoundException, MalformedURLException {
        Registry registry = LocateRegistry.getRegistry("localhost", 2020, new SslRMIClientSocketFactory());
        lookUp = (RMIInterface) registry.lookup("//localhost/TheServer");
//        lookUp = (RMIInterface) Naming.lookup("//localhost/TheServer");
    }

    public RMIInterface lookUpServer() {
        return lookUp;
    }
}
