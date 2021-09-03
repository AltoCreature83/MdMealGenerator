package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Interface to create meal objects

import javax.swing.ImageIcon;

// An interface that defines operations and parameters of Meal objects
public interface MealInformation{
	
        /**Method to return id (numeric) of 
        @return the meal ID*/
        public String getMealID();	
    
	/*Gets the name of the meal
	@return the meals name as a string*/
	public String getMealName();
	
	/*Gets the price of the meal in USD
	@return the meals price */
	public String getMealPrice();
	
	/*Gets the ingredients of the meal 
	@return the meals ingredients as a string that is delimited by commas*/
	public String getMealIngredients();
	
	/*Gets the amount of calories in the meal
	@return the meals calories as an integer*/
	public String getMealCalories();
	
	/*Gets the meals type (breakfast or dinner)
	@return meal type (breakfast is 0 and Dinner is 1) */
	public String getMealType();
                
        /**Method to return the image associated with the object
        @return an imageIcon object*/
        public String getMealIcon();
        
	
	/**Method to return object information as a string
         @return the objects definition as a string*/
        @Override
        public String toString();
	//end MealInterface 
}