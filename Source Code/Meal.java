package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: provide a class to define meal objects

import javax.swing.ImageIcon;

public class Meal implements MealInformation{
    String mealID;  //String to store meal id to identify icon
    String mealName;//String for meal name
    String mealPrice;//String for price
    String mealIngredients;//String for ingredients
    String mealCalories;//String for calories
    String mealType;//String for meal type, breakfast or dinner
    String mealIcon;//icon image to be associated with the meal
    
    //Constructor for meal object
    Meal(String mealID, String mealName, String mealPrice, String mealIngredients, 
            String mealCalories, String mealType, String mealIcon){
        this.mealName = mealName;
        this.mealPrice = mealPrice;
        this.mealIngredients = mealIngredients;
        this.mealCalories = mealCalories;
        this.mealType = mealType;
        this.mealIcon = mealIcon;
    }
    
    /**Method to return id (numeric) of 
    @return the mealID*/
    @Override
    public String getMealID(){
        return mealID;
    }
    
    /*Gets the name of the meal
    @return the meals name as a string*/
    @Override
    public String getMealName(){
        return mealName;
    }
    
    /*Gets the price of the meal in USD
    @return the meals price */
    @Override
    public String getMealPrice(){
        return mealPrice;
    }
    
    /*Gets the ingredients of the meal 
    @return the meals ingredients as a string that is delimited by commas*/
    @Override
    public String getMealIngredients(){
        return mealIngredients;
    }
    
    /*Gets the amount of calories in the meal
    @return the meals calries as an integer*/
    @Override
    public String getMealCalories(){
        return mealCalories;
    }
    
    /**Gets the meals type (breakfast or dinner)
	@return meal type Breakfast or Dinner */
    @Override
    public String getMealType(){
        return mealType;
    }
    
    /**Method to return the image associated with the object
    @return an imageIcon object*/
    @Override
    public String getMealIcon(){
        return mealIcon;
    }
    
    /**Method to return object information as a string
    @return the objects definition as a string*/
    @Override
    public String toString(){
        return (mealName + "\n" +
                "Price: " + mealPrice + "\n" +
                "Ingredients: " + mealIngredients + "\n" +
                "Calories: " + mealCalories + "\n" +
                "Type: " + mealType);
    }
}
