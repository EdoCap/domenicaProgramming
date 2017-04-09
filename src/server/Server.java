package server;

import shared.Hellable;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Pietro on 09/04/2017.
 */
public class Server {

	public static void main(String[] args){

		System.out.println("Inizializzo");
		try{
			Hellable sharello = new HelloImplementation();
			System.out.println("Try to bind");
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("sharello", sharello);

		}catch (Exception e){
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Partito");
	}
}
