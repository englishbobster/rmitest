package org.stos.server;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class RMIRegistryFactory {

    public static Registry createRmiRegistry(int rmiRegistryPort) throws RemoteException {
        return java.rmi.registry.LocateRegistry.createRegistry(rmiRegistryPort, new SslRMIClientSocketFactory(), new SslRMIServerSocketFactory(null, null , true));
    }
}
