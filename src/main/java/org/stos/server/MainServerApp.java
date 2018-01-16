package org.stos.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MainServerApp {

    public static void main(String[] args) {

        try {
            RMIRegistryFactory.createRmiRegistry(1099);
            Naming.rebind("//localhost/TheServer", new ServerOperation());
        } catch (RemoteException e) {
            System.out.println("remote exeption thrown with reason: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("malformed url exception thrown with reason: " + e.getMessage());
        }
        System.err.println("Server ready");
    }
}
