package shared;

import client.Resource;

import java.rmi.RemoteException;

/**
 * Created by Pietro on 09/04/2017.
 */
public class Producer extends Thread {
	Resource resource;

	public Producer(Resource r) {
		super();
		resource = r;
		this.setDaemon(false);
		this.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				resource.add();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}
