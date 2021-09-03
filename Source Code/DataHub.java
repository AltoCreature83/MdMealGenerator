package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: define all necessary data at runtime 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHub {
    //Create array lists to store program data
    public  static ArrayList<User> users = new ArrayList<>();
    public  static ArrayList<Meal> meals = new ArrayList<>();
    public static ArrayList<Meal> dinners = new ArrayList<>();
    public static ArrayList<Meal> breakfasts = new ArrayList<>();
    public static ArrayList<Meal> favorites = new ArrayList<>();
    public static ArrayList<Meal> excludeDislikes = new ArrayList<>();
    public static ArrayList<Location> locations = new ArrayList<>();
    public static ArrayList<Meal> generatedMeals = new ArrayList<>();
    
    public static int indexOfCurrentUser;
    
    /**Method to define an array with locations
     @throws java.io.IOException*/
    public static void createLocations() throws IOException {
		String line;
		
		try (BufferedReader br = new BufferedReader(new FileReader("location_information.txt"))){
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(",");
				locations.add(new Location(temp[0], temp[1], temp[2]));
			}
		}catch (FileNotFoundException e) {
	        	System.out.println("Error file not found");
		 }
	}
    
    public static ArrayList<Location> getLocations(){
        return locations;
    }
    
    /**Method to create an Array list of user objects by parsing a file users.txt*/
    public static void createUsers(){
        Scanner scanner = null; //create scanner
        String line = null;     //create string to store lines from users.txt
        String username = " ";  //String to hold usernames
        String password= " ";   //String to hold passwords
        String favorites;       //String to hold favorites, seperated by commas
        String dislikes;        //String to hold dislikes, seperated by commas
        String[] dislikesArray; //String array to hold Disliked items
        String[] favoritesArray;//String array to hold Favorited items
        User newUser = null;    //User object to be added to users list
        final String COMMA_DELIMITER = ","; //delimiter to be used to split up 
                                            //favorites and dislikes strings
        
        //Try to open the users.txt File
        try{
            //set scanner to scan file
            scanner = new Scanner(new File("users.txt"));
            
            //While file has information to parse
            while(scanner.hasNext()){
                //get next line from file
                line = scanner.nextLine();
                
                //Test line
                switch(line){
                    //If line is Username, next line will be the username
                    case "Username":
                        //set username to next line
                        username = scanner.nextLine();
                        break;
                    //If line is Password, next line will be the password
                    case "Password":
                        //set password to next line
                        password = scanner.nextLine();
                        //create user with gathered username and password
                        newUser = new User(username, password);
                        break;
                    //If line is Favorites, the next line will be the users favorites
                    case "Favorites":
                        //set favorites to next line
                        favorites = scanner.nextLine();
                        
                        //The users favorites are delimited with commas,
                        //split up the string into an array of strings
                        favoritesArray = favorites.split(COMMA_DELIMITER);
                        
                        //Use for loop to add contents of favoritesArray to user object
                        for (String favoritesArray1 : favoritesArray) {
                            newUser.addFavorite(favoritesArray1);
                        }
                        break;
                    //If line is Dislikes, the next line will be the users dislikes
                    case "Dislikes":
                        //set dislikes to next line
                        dislikes = scanner.nextLine();
                        
                        //The users dislikes are delimited with commas,
                        //split up the string into an array of strings
                        dislikesArray = dislikes.split(COMMA_DELIMITER);
                        
                        //Use for loop to add contents of dislikesArray to user object
                        for (String dislikesArray1 : dislikesArray) {
                            newUser.addDislike(dislikesArray1);
                        }
                        
                        //User definition is complete, add user to users ArrayList
                        users.add(newUser);
                        break;
                    //ignore empty spaces (default)
                    default:
                        break;
                }
            }
        }
        //Catch exception if file is not found
        catch(FileNotFoundException e){
            //continue program, user file is not necessary. new users file will 
            //be made if any user profiles are created.
        }
    }
    
    /**Method to return list of users*/
    public static ArrayList<User> getUsers(){
        return users;
    }
    
    /**Method to add user to users array*/
    public static void addUser(User user){
        users.add(user);
    }
    
    /**Method to set current user for program*/
    public static void setIndexOfCurrentUser(int index){
        indexOfCurrentUser = index;
    }
    
    /**Method to set current user for program*/
    public static int getIndexOfCurrentUser(){
        return indexOfCurrentUser;
    }
    
    /**Method to export all user information to users.txt
     @param users, an ArrayList of users objects to be written to a file*/
    public static void exportUsers(ArrayList<User> users){
        try{
            //delete old user information
            File usersOld = new File("users.txt");
            usersOld.delete();
            //re create users.txt, set print stream to output to users.txt
            PrintStream out = new PrintStream(new FileOutputStream("users.txt"));
            System.setOut(out);
            
            //Output all user information to users.txt
            for(int i = 0; i < users.size(); i ++){
            User tempUser = users.get(i);
            System.out.println(tempUser.toString());
            }
            //close output stream
            out.close();
            //set output stream back to standard console
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        }
        //Catch exception if file could not be created
        catch(FileNotFoundException e){
            System.out.println("Error while exporting user information");
        }
    }
    
        /**Method to parse meal_information.txt and create an list of meal objects
     @param meals, an array list of meals*/
    public static void createMeals(){
        Scanner scanner = null; //create scanner
        String line = null;     //create string to store lines from users.txt
        String mealID = "";     //String to hold mealID
        String mealName = "";   //String to hold mealName
        String mealPrice = "";  //String to hold mealPrice
        String mealIngredients = "";//String to hold ingredients
        String mealCalories = "";   //string to hold calories
        String mealType = "";       //String to hold meal type, breakfast or dinner
        String mealIcon = null;  //icon to be associated with meal
        
        //Try to open meal_information.txt
        try{
            //set scanner to scan file
            scanner = new Scanner(new File("meal_information.txt"));
            
            //While file has information to parse
            while(scanner.hasNext()){
                //get next line from file
                line = scanner.nextLine();
                
                //test line
                switch(line){
                    //If line is ID next line is mealID
                    case "ID":
                        mealID = scanner.nextLine();
                        //mealID is used for identifying photo, define imageIcon
                        mealIcon = (mealID + ".jpg");
                        break;
                    //If line is name, next line is mealName
                    case "Name":
                        mealName = scanner.nextLine();
                        break;
                    //If line is Price, next line is MealPrice    
                    case "Price":
                        mealPrice = scanner.nextLine();
                        break;
                    //If line is Ingredients, next line is mealIngredients
                    case "Ingredients":
                        mealIngredients = scanner.nextLine();
                        break;
                    //If line is calories, next line is mealCalories
                    case "Calories":
                        mealCalories = scanner.nextLine();
                        break;
                    //If line is Type, next line is mealType, object definition is complete, create new Meal
                    case "Type":
                        mealType = scanner.nextLine();
                        //create new meal with found information
                        Meal newMeal = new Meal(mealID, mealName, mealPrice, mealIngredients, 
                                mealCalories, mealType, mealIcon);
                        meals.add(newMeal);
                        break;
                    //Ignore other lines
                    default:
                        break;
                }
            }
        }
        
        //Catch exception if file is not found
        catch(FileNotFoundException e){
            System.out.println("meal_information.txt is damaged or missing, "
                    + "the program cannot run without this data");
        }
    }   
    
    /**Method to return meals list*/
    public static ArrayList<Meal> getMeals(){
        return meals;
    }
    
    /**Method to sort the meals array list into two separate array lists breakfasts and dinners
    @param breakfasts, an ArrayList to be filled with breakfast meals
    @param dinners, an ArrayList to be filled with dinner meals*/
    public static void createDinnersAndBreakfasts(){
        Meal tempMeal;  //temporary meal to be added to a list
        String tempType;
        for(int i = 0; i < meals.size(); i++){
            tempMeal = meals.get(i);    //get meal object
            tempType = tempMeal.getMealType();//get type
            //if type is dinner, add to dinner list
            if(tempType.equals("Dinner")){
                dinners.add(tempMeal);
            }
            //if type is breakfast, add to breakfast array
            else{
                breakfasts.add(tempMeal);
            } 
        }
    }
    
    /**Method to return list of dinners*/
    public static ArrayList<Meal> getDinners(){
        return dinners;
    }
    
    /**Method to return list of breakfasts*/
    public static ArrayList<Meal> getBreakfasts(){
        return breakfasts;
    }
        
    /**Method to fill a list with Meal objects based off of names of meals from users favorites
    @param user, the user to create the favorites from*/
    public static void createFavorites(User user){
        ArrayList<String> userFav = user.getFavorites();//get user favorites
        String tempMealName;//String to hold name of meal from favorites
        Meal tempMeal;//Temp meal to be added to favorites meal list
        if(userFav.size() > 0){
            //iterate through user favorites
            for(int i = 0; i < userFav.size(); i++){
                tempMealName = userFav.get(i);//get meal name
                //iterate through meals list
                for(int j = 0; j < meals.size(); j++){
                    tempMeal = meals.get(j);//get meal
                    //if tempMeal name and meal name from users favorites are same,
                    //add meal to favorites meal array
                    if(tempMealName.equals(tempMeal.getMealName())){
                        favorites.add(tempMeal);
                    }
                }
            }
        }
    }
    
    public static ArrayList<Meal> getFavoriteMeals(){
        return favorites;
    }
    
    
    /**Method to create meals excluding user dislikes*/
    public static void createMealsExcludingDislikes(User user){
        excludeDislikes = meals;
        //get user dislikes
        ArrayList<String> userDis = user.getDislikes();
        //initialize temp variables
        String tempMealName;
        Meal tempMeal;
        
        //if user has dislikes, iterate through them
        if(userDis.size() > 0){
            //iterate through user dislikes
            for(int i = 0; i < userDis.size(); i++){
                //get name of user dislike meal
                tempMealName = userDis.get(i);
                //iterate through meals array list
                for(int j = 0; j < excludeDislikes.size(); j++){
                    //get meal
                    tempMeal = excludeDislikes.get(j);
                    //if meal is disliked, remove from list
                    if(tempMealName.equals(tempMeal.getMealName())){
                        excludeDislikes.remove(tempMeal);
                    }
                }
            }
        }      
    }
    
    /**Method to return array of meals excluding user dislikes*/
    public static ArrayList<Meal> getExcludeDislikes(){
        return excludeDislikes;
    }
}