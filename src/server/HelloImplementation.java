package server;

import shared.Hellable;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Edoardo on 09/04/17.
 */
public class HelloImplementation extends UnicastRemoteObject implements Hellable {

	private int count;

	public HelloImplementation() throws RemoteException {
		count = 0;
	}
	@Override
	public String sayHelloTo(String name) {
		count++;
		System.out.println("Ciao " + name);
		return count + ":Ciao " + name;
	}
}
