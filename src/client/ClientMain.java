package client;


import shared.Consumer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ClientMain {


	public static void main(String[] args){
		try{
			Resource res = new Resource();
			Registry registry = LocateRegistry.getRegistry(1099);
			registry.bind("resource", res);
			new Consumer(res);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
