package org.stos.client;

import org.stos.rmi.RMIInterface;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;

public class ClientOperation {
    private static RMIInterface lookUp;

    ClientOperation(int port, boolean sslEnabled) throws RemoteException, NotBoundException{
        RMIClientSocketFactory csf = null;
        if (sslEnabled) {
            csf = new SslRMIClientSocketFactory();
        }
        Registry registry = LocateRegistry.getRegistry("localhost", port, csf);
        lookUp = (RMIInterface) registry.lookup("//localhost/TheServer");
    }

    public RMIInterface lookUpServer() {
        return lookUp;
    }
}
