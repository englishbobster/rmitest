package org.stos.server;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;

public class MainServerApp {

    private static final int RMI_REGISTRY_PORT = 2020;
    private static final boolean sslEnabled = true;
    private static RMIClientSocketFactory csf = null;
    private static RMIServerSocketFactory ssf = null;

    private static Registry rmiRegistry;

    public static void main(String[] args) {
        setPropsShared();
        if (sslEnabled) {
            csf = new SslRMIClientSocketFactory();
            ssf = new SslRMIServerSocketFactory(null, null, true);
        }
        try {
            rmiRegistry = RMIRegistryFactory.createRmiRegistry(RMI_REGISTRY_PORT, csf, ssf);
            System.out.println("registry running on Port: " + RMI_REGISTRY_PORT);
            rmiRegistry.bind("//localhost/TheServer", new ServerOperation(csf, ssf));
        } catch (RemoteException e) {
            System.out.println("remote exception thrown with reason: " + e.getMessage());
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

    private static void setPropsShared() {
        String pass = "sharedkeystore";
        System.setProperty("javax.net.ssl.debug", "all");
        System.setProperty("javax.net.ssl.keyStore", "./sharedcert/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", pass);
        System.setProperty("javax.net.ssl.trustStore", "./sharedcert/truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", pass);
    }

}
