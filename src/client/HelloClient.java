package client;

import shared.Hellable;
import sun.util.locale.provider.LocaleResources;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

/**
 * Created by Edoardo on 09/04/17.
 */
public class HelloClient {

	public static void main(String[] args){
		try {
			Registry registry = LocateRegistry.getRegistry();
			Hellable remote = (Hellable) registry.lookup("sharello");
			for (int i = 0; i < 10; i++) {
				System.out.println(remote.sayHelloTo("Pietro"));
			}

		}catch (Exception e){
			e.printStackTrace();
			return;
		}




	}

}
