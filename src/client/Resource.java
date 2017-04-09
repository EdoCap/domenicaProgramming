package client;

import shared.Addable;
import shared.Consumer;
import shared.Producer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Resource extends UnicastRemoteObject implements Addable {
	private int value;

	public Resource()throws RemoteException{
		value = 0;
	}

	public synchronized void add() throws InterruptedException, RemoteException {
		value ++;
		while (value > 3){
			System.out.println( Thread.currentThread().getId() + "Already full, can't add");
			wait();

		}
		System.out.println(Thread.currentThread().getId() + "added, new value " + value);
		notifyAll();
	}
	public synchronized void consume() throws InterruptedException {

		while (value < 2){
			System.out.println(Thread.currentThread() + "Want to consume but can't");
			wait();
		}
		value --;
		System.out.println(Thread.currentThread() + "Consumed, new value " + value);
//		notifyAll();
	}

	public static void main	(String[] args) throws RemoteException {

		Resource r = new Resource();

		new Consumer(r);
		System.out.println("Created consumer");
		new Producer(r);
		System.out.println("Created producer");

	}
}
