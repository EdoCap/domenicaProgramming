package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Pietro on 09/04/2017.
 */
public interface Addable extends Remote {

	public void add() throws RemoteException, InterruptedException;
}
