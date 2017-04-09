package shared;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Pietro on 09/04/2017.
 */
public interface Hellable extends Remote {
	String sayHelloTo(String name) throws RemoteException, NotBoundException, MalformedURLException;
	void aspettaTurno() throws RemoteException;
}
