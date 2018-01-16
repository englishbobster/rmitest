package org.stos.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class MainServerApp {

    public static final int RMI_REGISTRY_PORT = 2020;
    private static Registry rmiRegistry;

    public static void main(String[] args) {

        try {
            setProps();
            rmiRegistry = RMIRegistryFactory.createRmiRegistry(RMI_REGISTRY_PORT);
            System.out.println("registry running on Port: " + RMI_REGISTRY_PORT);
            rmiRegistry.bind("//localhost/TheServer", new ServerOperation());
            //Naming.rebind("//localhost/TheServer", new ServerOperation());
        } catch (RemoteException e) {
            System.out.println("remote exception thrown with reason: " + e.getMessage());
        /*} catch (MalformedURLException e) {
            System.out.println("malformed url exception thrown with reason: " + e.getMessage());*/
        } catch (AlreadyBoundException e) {
            System.out.println("alreadybound exeption thrown with reason: " + e.getMessage());
        }
        System.err.println("Server ready");
    }

    private static void setProps() {
        String pass = "serverkeystore";
        System.setProperty("javax.net.ssl.debug", "all");
        System.setProperty("javax.net.ssl.keyStore", "./servercert/serverkeystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", pass);
        System.setProperty("javax.net.ssl.trustStore", "./servercert/servertruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", pass);
    }
}
