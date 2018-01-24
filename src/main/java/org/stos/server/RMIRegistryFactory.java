package org.stos.server;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;

public class RMIRegistryFactory {

    public static Registry createRmiRegistry(int rmiRegistryPort, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        return java.rmi.registry.LocateRegistry.createRegistry(rmiRegistryPort, csf, ssf);
    }
}
