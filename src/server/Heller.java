package server;

/**
 * Created by Pietro on 09/04/2017.
 */
public class Heller {

	public synchronized String hi(String s){
		notifyAll();
		return "Hi " + s;
	}
}
