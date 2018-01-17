package org.stos.client;

import org.stos.rmi.RMIInterface;
import org.stos.rmi.trxobjects.TheThing;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClientApp {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        setPropsShared();
        RMIInterface server = new ClientOperation().lookUpServer();
        String result = server.helloTo("brian");
        System.out.println("The server took: " + "brian" + " and answered:\n" + result);

        TheThing theThingFromTheServer = server.sendTheThing();
        System.out.println("Oh dear god! Got a thing from the server:");
        System.out.println(theThingFromTheServer.toString());
    }

    private static void setProps() {
        String pass = "clientkeystore";
        System.setProperty("javax.net.ssl.debug", "all");
        System.setProperty("javax.net.ssl.keyStore", "./clientcert/clientkeystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", pass);
        System.setProperty("javax.net.ssl.trustStore", "./clientcert/clienttruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", pass);
        System.setProperty("java.rmi.dgc.leaseValue", "300000");
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
