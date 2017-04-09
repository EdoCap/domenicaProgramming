package server;

import shared.Hellable;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Pietro on 09/04/2017.
 */
public class Server {

	public static void main(String[] args){

		Heller h = new Heller();
		System.out.println("Inizializzo");
		try{
			Hellable sharello = new HelloImplementation(h);
			Hellable sharello2 = new HelloImplementation(h);
			System.out.println("Try to bind");
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("sharello", sharello);
			registry.bind("sharello2", sharello2);
			/*sharello.wait(3000);
			registry.unbind("sharello");*/

		}catch (Exception e){
			e.printStackTrace();
			return;
		}
		System.out.println("Partito");
	}
}
