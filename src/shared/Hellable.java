package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Pietro on 09/04/2017.
 */
public interface Hellable extends Remote {
	public String sayHelloTo(String name) throws RemoteException;
}
