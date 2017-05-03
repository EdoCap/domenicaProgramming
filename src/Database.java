package com.jdojo.tests;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

/**Database containing records
 * Created by Pietro on 29/04/2017.
 */
public class Database {
	private final Gson gson = new Gson();
	private final String PATH = "src/com/jdojo/tests/database1.db";

	private File database;
	private TreeSet<Record> table;
	//constructor

	public Database() throws IOException {
		database = new File(PATH);
		table = new TreeSet<>();
		loadRecords();
	}

	//public interface

	public void print(){
		table.forEach((record -> System.out.println(record)));
	}

	public boolean isEmpty(){
		return table.isEmpty();
	}

	public boolean authenticate(String username, String password){

		if (table.contains(new Record(username, null)))
			return table.ceiling(new Record(username, null)).authenticate(password);
		else
			return false;
	}

	public void insert(Record record) throws UserAlreadyTakenException{
		if (table.contains(record))
			throw new UserAlreadyTakenException();

		table.add(record);
	}

	public void close(){
		writeToFile();
	}

	//private methods

	private void loadRecords() throws IOException {
		//check if the file exists
		if (!database.exists()){
			database.createNewFile();
			return;
		}
		//if exists then load it
		Scanner reader = null;
		reader = new Scanner(database);

		while(reader.hasNextLine()){
			table.add(gson.fromJson(reader.nextLine(), Record.class));
		}
	}

	private void writeToFile() {
		PrintWriter writer = null;

		try{
			writer = new PrintWriter(database);
		} catch (FileNotFoundException e) {
			System.err.println("Can't find the database file, write aborted.");
			return;
		}

		//write each node into the file, in the form : "User::UserStatistics"
		PrintWriter finalWriter = writer;
		table.forEach((record)->{
			finalWriter.println(gson.toJson(record));
		});

		writer.flush();
		writer.close();
	}

	//others

	public static void main(String[] args) throws IOException {
		Scanner tastiera = new Scanner(System.in);
		Database d = new Database();
		String username, password;

		d.print();

		for (int i = 0; i < 5; i++) {
			System.out.println("inserisci il nome :");
			username = tastiera.nextLine();
			System.out.println("inserisci la password :");
			password = tastiera.nextLine();

			try {
				d.insert(new Record(username,password));
			} catch (UserAlreadyTakenException e) {
				System.err.println("User already in use!");
			}
			d.print();
		}

		for (int i = 0; i < 3; i++) {
			System.out.println("inserisci il nome :");
			username = tastiera.nextLine();
			System.out.println("inserisci la password :");
			password = tastiera.nextLine();

			System.out.println(d.authenticate(username,password));
		}

		d.close();
	}

}
