package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Implement the userInformation interface so that User objects
// can be defined and manipulated

import java.util.ArrayList;

public class User implements UserInformation{
    String username;    //String to store username
    String password;    //String to store password
    
    //Create array lists for users favorites and dislikes
    ArrayList<String> favorites = new ArrayList<>();
    ArrayList<String> dislikes = new ArrayList<>();
    
    /**Constructor for new user object
     @param username, a string to define a users name
     @param password, a string to define a users password
     @param favorites, an array list of a users favorite food items
     @param dislikes, an array list of food items the user dislikes*/
    public User(String username, String password,
                ArrayList<String> favorites, ArrayList<String> dislikes){
        //define user object with parameters
        this.username = username;
        this.password = password;
        this.favorites = (ArrayList<String>) favorites.clone();
        this.dislikes = (ArrayList<String>) dislikes.clone();
    }
    
    /**Constructor for new user object
     @param username, a string to define a users name
     @param password, a string to define a users password*/
    User(String username, String password){
        //define user object with given parameters
        this.username = username;
        this.password = password;
    }
    
    /*Gets the user's username
    @return String of the user's username*/
    @Override
    public String getUsername(){
        return username;
    }
	
    /*Gets the user's password
    @return String of the user's password*/
    @Override
    public String getPassword(){
        return password;
    }

    /* Allows user to save an item to favorites
    @return True if item was successfully added, false if failed*/
    @Override
    public boolean addFavorite(String item){
        //try to add item to favorites list, if exception is thrown, 
        //return false to show item failed to be added
        try{
            favorites.add(item);
            return true;
        }
        catch(Exception e){
            return false;
        }    
    }
	
    /*Allows user to remove previously saved item from favorites
    @return true if item was successfully removed, false if failed*/
    @Override
    public boolean removeFavorite(String item){
        //try to remove item to favorites list, if exception is thrown, 
        //return false to show item failed to be removed
        try{
            favorites.remove(item);
            return true;
        }
        catch(Exception e){
            return false;
        } 
    }

    /**Method to remove all favorites*/
    @Override
    public void clearFavorites(){
        favorites.clear();
    }

    /* Gets the favorites associated to a user
    @return ArrayList<String> of all favorites*/
    @Override
    public ArrayList<String> getFavorites(){
        //make a copy of the favorites list and return the copy
        ArrayList<String> favoritesClone = (ArrayList<String>) favorites.clone();
        return favoritesClone;
    }

    /* Allows user to save an item to dislikes
    @return True if item was successfully added, false if failed*/
    @Override
    public boolean addDislike(String item){
        //try to add item to favorites list, if exception is thrown, 
        //return false to show item failed to be added
        try{
            dislikes.add(item);
            return true;
        }
        catch(Exception e){
            return false;
        } 
    }

    /*Allows user to remove previously saved item from dislikes
    @return true if item was successfully removed, false if failed*/
    @Override
    public boolean removeDislike(String item){
        //try to remove item to favorites list, if exception is thrown, 
        //return false to show item failed to be removed
        try{
            dislikes.remove(item);
            return true;
        }
        catch(Exception e){
            return false;
        } 
    }

    /**Method to remove all dislikes*/
    @Override
    public void clearDislikes(){
        dislikes.clear();
    }

    /* Gets the dislikes associated to a user
    @return ArrayList<String> of all dislikes*/
    @Override
    public ArrayList<String> getDislikes(){
        //make a copy of the dislikes list and return the copy
        ArrayList<String> dislikesClone = (ArrayList<String>) dislikes.clone();
        return dislikesClone;
    }

    /* Displays all user data as a String
    @return String of user data*/
    @Override
    public String toString(){
        //Convert arraylists favorites and dislikes to comma delimited strings
        String favoritesCommaDelimited = "";    //empty string to store converted favorites string
        String dislikesCommaDelimited = "";     //empty string to store converted dislikes string
        
        //use for loops to iterate through likes and dislikes ArrayLists,
        //append string objects from the arrayList to the comma delimited String
        for(int i = 0; i < favorites.size(); i++){
            favoritesCommaDelimited += (favorites.get(i) + ","); //add comma at end of string object
        }
        for(int i = 0; i < dislikes.size(); i++){
            dislikesCommaDelimited += (dislikes.get(i) + ",");  //add comma at end of string object
        }
        
        //return a formatted string containing information about the user object.
        //the format is to match the structure of the users.txt file so that the
        //program can parse through the file with ease.
        return ("\nUsername\n" + username +
                "\nPassword\n" + password +
                "\nFavorites\n" + favoritesCommaDelimited +
                "\nDislikes\n" + dislikesCommaDelimited);
    }
}
