package com.jdojo.tests;

/** Class used to represent a User in the database
 * @author Pietro Alovisi
 * @since 28/4/2017
 * @version 0.1
 */
public class User implements Comparable<User>{

	private String username;
	private String password;

	/** Only constructor for the class
	 * @param username the username of the user
	 * @param password the password of the user
	 */
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}

	/**Compare two users by their username*/
	@Override
	public int compareTo(User user) {
		if (this.username.compareTo(user.username) != 0)
			return this.username.compareTo(user.username);
		else
			return this.password.compareTo(user.password);

	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof User))
			return false;
		return this.username.equals(((User) obj).username);
	}

	@Override
	public String toString() {
		return username;
	}
}
