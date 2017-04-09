package shared;

import client.Resource;

/**
 * Created by Pietro on 09/04/2017.
 */
public class Consumer extends  Thread{
	Resource resource;

	public Consumer(Resource r) {
		super();
		resource = r;
		this.setDaemon(false);
		this.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				resource.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
