package server;

import shared.Hellable;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Edoardo on 09/04/17.
 */
public class HelloImplementation extends UnicastRemoteObject implements Hellable , Runnable{
	private int count;
	private Heller saluatatore;

	public HelloImplementation(Heller saluatatore) throws RemoteException {
		count = 0;
		this.saluatatore = saluatatore;
		new Thread(this).start();
	}
	@Override
	public String sayHelloTo(String name) throws RemoteException, NotBoundException, MalformedURLException {
		/*count++;
		if (count == 7){
			exit();
			return null;
		}
		System.out.println("Ciao " + name);
		return count + ":Ciao " + name;*/

		return saluatatore.hi(name);
	}

	@Override
	public void aspettaTurno() throws RemoteException {
		try {
			synchronized (saluatatore){
				saluatatore.wait();
			}
			return;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void exit() throws RemoteException, NotBoundException, MalformedURLException {
		Naming.unbind("sharello");
		unexportObject(this, true);
	}

	@Override
	public void run() {

	}
}
