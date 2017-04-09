package server;

import shared.Actionable;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


class ClientHandler extends UnicastRemoteObject implements Actionable {

	ClientHandler() throws RemoteException {
	}


}
