package com.jdojo.tests;

/** Class used to model a timer
 * @author Pietro Alovisi
 */
public class Timer extends Thread{

	/**Timeout of the timer*/
	private long timeout;

	/** Constructor of the class
	 * @param timeout the timout to give to the timer
	 */
	public Timer(long timeout){
		this.timeout = timeout;
		this.start();
	}

	/**Constructor of the class
	 * Sets the timeout to default : 2 seconds
	 */
	public Timer(){
		timeout = 2000;
		this.start();
	}

	@Override
	public void run() {
		try {
			this.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) throws InterruptedException {

		new Configurations();
		if (true){
			return;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Turn of " + (i%2 == 0 ? "EVEN" : "ODD"));
			new Timer(i*200).join();
		}
	}
}
