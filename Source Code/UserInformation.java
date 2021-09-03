package sample;// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: 

import java.util.ArrayList;


/*This interface will define the operations of User objects*/
public interface UserInformation {

	/*Gets the user's username
	 @return String of the user's username*/
	public String getUsername();
	
	/*Gets the user's password
	 @return String of the user's password*/
	public String getPassword();
	
	/* Allows user to save an item to favorites
	 @return True if item was successfully added, false if failed*/
	public boolean addFavorite(String item);
	
	/*Allows user to remove previously saved item from favorites
	 @return true if item was successfully removed, false if failed*/
	public boolean removeFavorite(String item);
	
	// Removes all favorites
	public void clearFavorites();
	
	/* Gets the favorites associated to a user
	 @return ArrayList<String> of all favorites*/
	public ArrayList<String> getFavorites();
	
	/* Allows user to save an item to dislikes
	 @return True if item was successfully added, false if failed*/
	public boolean addDislike(String item);

	/*Allows user to remove previously saved item from dislikes
	 @return true if item was successfully removed, false if failed*/
	public boolean removeDislike(String item);
	
	//Removes all dislikes
	public void clearDislikes();
	
	/* Gets the dislikes associated to a user
	 @return ArrayList<String> of all dislikes*/
	public ArrayList<String> getDislikes();
	
	/* Displays all user data as a String
	 @return String of user data*/
        @Override
	public String toString();
	//end UserInterface
}
