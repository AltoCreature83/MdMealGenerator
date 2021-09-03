package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Provide functions to generate random meals  

import java.util.ArrayList;

public class GenerateMeal {
    /**Method to generate a single meal
     @param meals, an arrayList of Meal objects
     @return a meal object*/
    public static Meal generateMeal(ArrayList<Meal> meals){
        int maxInt = meals.size();//get size of array
        //generate random number between 0 and size of array
        int randomID = (int) (Math.random() * maxInt);
        //Get meal from the random index that was generated
        Meal randMeal = meals.get(randomID);
        //return random meal
        return randMeal;
    }
    
    /**Method to generate multiple random meals
     @param meals, array list of meal objects
     @param amount, the number of meals to generate
     @return a list of meal objects*/
    public static ArrayList<Meal> genearateMultipleMeals(ArrayList<Meal> meals, int amount){
        //Define meal array list to be returned
        ArrayList<Meal> randMeals = new ArrayList<>();
        //use for loop to call generateMeal as many times as specified
        for(int i = 0; i < amount; i++){
            //add randomly generated meal to list
            randMeals.add(generateMeal(meals));
        }
        //return the random list
        return randMeals;
    }
}