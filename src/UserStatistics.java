package com.jdojo.tests;

/** Wrap all the game statistics for a specif user
 * Created by Pietro on 29/04/2017.
 */
public class UserStatistics {

	private int numberOfGames;
	private int numberOfWins;
	private int numberOfLoss;

	//constructor

	public UserStatistics(){
		numberOfGames = 0;
		numberOfWins = 0;
		numberOfLoss = 0;
	}

	public UserStatistics(int numberOfGames, int numberOfWins, int numberOfLoss) {
		this.numberOfGames = numberOfGames;
		this.numberOfWins = numberOfWins;
		this.numberOfLoss = numberOfLoss;
	}

	//getters

	public int getNumberOfGames() {
		return numberOfGames;
	}

	public int getNumberOfWins() {
		return numberOfWins;
	}

	public int getNumberOfLoss() {
		return numberOfLoss;
	}

	//increment methods

	public void increaseNumberOfGames(){
	numberOfGames++;
	}

	public void increaseNumberOfWins(){
		numberOfWins++;
	}

	public void increaseNumberOfLoss(){
		numberOfLoss++;
	}

	//other methods

	@Override
	public String toString() {
		return  "\tplayed : " + numberOfGames + "\n\t" +
				"winned :" + numberOfWins +	  "\n\t" +
				"lost : " + numberOfLoss;
	}
}