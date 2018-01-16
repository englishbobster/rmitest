package org.stos.client;

import org.stos.rmi.RMIInterface;
import org.stos.rmi.trxobjects.TheThing;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClientApp {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        RMIInterface server = new ClientOperation().lookUpServer();
        String result = server.helloTo("brian");
        System.out.println("The server took: " + "brian" + " and answered:\n" + result);

        TheThing theThingFromTheServer = server.sendTheThing();
        System.out.println("Oh dear god! Got a thing from the server:");
        System.out.println(theThingFromTheServer.toString());
    }

}
