package server;

import shared.Addable;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


//main del server
public class Main {

	public static void main(String[] args) {


		try{
			Scanner tastiera = new Scanner(System.in);
			ClientHandler c1 = new ClientHandler();
			ClientHandler c2 = new ClientHandler();

			Registry registry = LocateRegistry.createRegistry(1099);
//			registry.bind("client1", c1);
//			registry.bind("client2", c2);

			tastiera.nextLine();
			System.out.println("getting resources");
			Addable res = (Addable) registry.lookup("resource");
			System.out.println("getted");
			for (int i = 0; i < 10; i++) {
				res.add();
			}

			System.out.println("Start");

		}catch (Exception e){
			e.printStackTrace();
			return;
		}
		System.out.println("Up and running");
	}
}
