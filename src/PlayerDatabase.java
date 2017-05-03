package com.jdojo.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;
import com.google.gson.*;

/** Database for Users' statistics
 * Created by Pietro on 28/04/2017.
 */
public class PlayerDatabase {

	private final String PATH = "src/com/jdojo/tests/database.db";
	private final Gson gson = new Gson();

	private TreeMap<User, UserStatistics> table;
	private File database;

	//constructors

	public PlayerDatabase(){
		table = new TreeMap<>();
		database = new File(PATH);

		// load all the records into the object
		loadRecords();
	}

	//public interface

	/**do all the housekeeping necessary to close the database*/
	public void close() {
		writeToDb();
	}

	/**Prints to the standard output all the records saved into the table*/
	private void print() {
		table.forEach((user, userStatistics) -> System.out.println(user + ":\n" + userStatistics));
	}

	/** Adds a user with empty statistics
	 * @param user user to add
	 * @throws UserAlreadyTakenException
	 */
	public synchronized void addNewUser(User user) throws UserAlreadyTakenException {
		addRecord(user, new UserStatistics());
	}

	/** Adds a couple < user, statistics > to the database
	 * @param user user to add
	 * @param statistics statistics relative to the user
	 * @throws UserAlreadyTakenException
	 */
	public synchronized void addRecord(User user, UserStatistics statistics) throws UserAlreadyTakenException{
		if (table.containsKey(user)){
			throw new UserAlreadyTakenException();
		}else{
			table.put(user, statistics);
		}
	}

	//private methods

	/**Writes all the record into the database file	*/
	private void writeToDb(){
		PrintWriter writer = null;

		try{
			writer = new PrintWriter(database);
		} catch (FileNotFoundException e) {
			System.err.println("Can't find the database file, write aborted.");
			return;
		}

		//write each node into the file, in the form : "User::UserStatistics"
		PrintWriter finalWriter = writer;
		table.forEach((user, stats)->{
			finalWriter.println(gson.toJson(user) + "::" + gson.toJson(stats));
		});

		writer.flush();
		writer.close();
	}

	private void loadRecords() {
		System.out.println("Loading database from " + PATH +"...");
		try{
			if (database.exists())
				readRecords();
			else if (database.createNewFile())
				System.out.println("Database not found, creating a new one");
			else
				System.err.println("Can't create the database at " + PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readRecords() {
		Scanner fileReader;
		String line;
		String[] record;

		try{
			fileReader = new Scanner(database);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		//read every line
		while(fileReader.hasNextLine()){
			line = fileReader.nextLine();
			record = line.split("::");
			table.put(gson.fromJson(record[0],User.class),gson.fromJson(record[1],UserStatistics.class));
		}

		fileReader.close();
	}

	void populate(){
		table.put(new User("Pietro","fioregay"), new UserStatistics());
		table.put(new User("Coso","fioregay"),new UserStatistics());
		writeToDb();
	}

	public static void main(String [] args){
		PlayerDatabase db = new PlayerDatabase();
		db.print();
		db.close();

	}
}
