package com.jdojo.tests;

/**
 * Created by Pietro on 29/04/2017.
 */
public class Record implements Comparable<Record> {

	private String username;
	private String password;
	private UserStatistics stats;

	public Record(String username, String password) {
		this.username = username;
		this.password = password;
		stats = new UserStatistics();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Record){
			return username.equals(((Record) obj).username);
		}else
			return false;
	}

	@Override
	public int compareTo(Record o) {
		return this.username.compareTo(o.username);
	}

	@Override
	public String toString() {
		return username +" , " + password + " : \n" + stats;
	}

	public boolean authenticate(String password) {
		return this.password.equals(password);
	}
}
