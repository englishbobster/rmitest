package org.stos.server;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class MainServerApp {

    public static void main(String[] args) {

        try {
            Registry rmiRegistry = RMIRegistryFactory.createRmiRegistry(1099);
            rmiRegistry.rebind("//localhost/TheServer", new ServerOperation());
            //Naming.rebind("//localhost/TheServer", new ServerOperation());
        } catch (RemoteException e) {
            System.out.println("remote exeption thrown with reason: " + e.getMessage());
        /*} catch (MalformedURLException e) {
            System.out.println("malformed url exception thrown with reason: " + e.getMessage());*/
        }
        System.err.println("Server ready");
    }
}
