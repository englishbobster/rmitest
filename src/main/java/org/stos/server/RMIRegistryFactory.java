package org.stos.server;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class RMIRegistryFactory {

    public static Registry createRmiRegistry(int rmiRegistryPort) throws RemoteException {
        System.setProperty("java.rmi.dgc.leaseValue", "300000");
        return java.rmi.registry.LocateRegistry.createRegistry(rmiRegistryPort);
    }
}
