package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: controller for generated meals display scene  

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**class to display generated meals*/
public class GeneratedMealController implements Initializable {
    //initialize global variables
    static int mealCounter = 0;
    //get user location
    static int indexOfCurrent = DataHub.getIndexOfCurrentUser();
    //get generated meals
    ArrayList<Meal> generatedMeals = DataHub.generatedMeals;
    //initialize boolean arrays for check boxes
    boolean[] dislikes = new boolean[generatedMeals.size()];
    boolean[] favorites = new boolean[generatedMeals.size()];
    
    //initialize fxml fields
    @FXML
    private ImageView mealImage;
    
    @FXML
    private ListView mealInfo;
    
    @FXML
    private Button viewNext;
    
    @FXML
    private Button viewPrevious;
    
    @FXML
    private CheckBox favorite;
    
    @FXML
    private CheckBox dislike;
    
    /**Override method for initializ
     @param url
     @param rb*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mealCounter = 0;
        setChecksToFalse();
        viewNext.setVisible(false);
        viewPrevious.setVisible(false);
        Meal firstMeal = generatedMeals.get(0);
        Image firstImage = new Image(firstMeal.getMealIcon());
        mealImage.setImage(firstImage);
            
        //get meal info
        String info = firstMeal.toString();
        String outOf = ("Displaying meal\n 1 out of " + generatedMeals.size());
        mealInfo.getItems().setAll(info, outOf);
            
        //if there are more than one item in favorites, display view next button
        if(generatedMeals.size() > 1){
        viewNext.setVisible(true);
        }
    }    
    
    /**method to view next item
     @param event*/
    public void viewNextOnAction(ActionEvent event){
        //if end of array has not been reached display next item
        if(mealCounter < generatedMeals.size() - 1){
            //set view previous button to visible
            viewPrevious.setVisible(true);
            //increment counter
            mealCounter++;
            
            //get meal icon
            Meal tempMeal = generatedMeals.get(mealCounter);
            Image tempImage = new Image(tempMeal.getMealIcon());
            mealImage.setImage(tempImage);
            
            //get meal info
            String info = tempMeal.toString();
            String outOf = ("Displaying favorite\n"+ (mealCounter + 1) + " out of " + generatedMeals.size());
            mealInfo.getItems().setAll(info, outOf);

            //If end reached hide next button
            if(mealCounter == generatedMeals.size() - 1){
                viewNext.setVisible(false);
            } 
            
            //get checkBox definitions from boolean arrays
            if(favorites[mealCounter] == true){
                favorite.setSelected(true);
            }
            else{
                favorite.setSelected(false);
            }
            //get checkBox definitions from boolean arrays
            if(dislikes[mealCounter] == true){
                dislike.setSelected(true);
            }
            else{
                dislike.setSelected(false);
            }
        }
    }
    
    public void viewPrevOnAction(ActionEvent event){
        //if beginning of array has not been reached display previous item
        if(mealCounter > 0){
            //set view next button to visible
            viewNext.setVisible(true);
            //decrement counter
            mealCounter--;
            
            //get meal icon
            Meal tempMeal = generatedMeals.get(mealCounter);
            Image tempImage = new Image(tempMeal.getMealIcon());
            mealImage.setImage(tempImage);
            
            //get meal info
            String info = tempMeal.toString();
            String outOf = ("Displaying favorite\n"+ (mealCounter + 1) + " out of " + generatedMeals.size());
            mealInfo.getItems().setAll(info, outOf);
            
            //if beginning reached hide previous button
            if(mealCounter == 0){
                viewPrevious.setVisible(false);
            } 
            
            //get checkBox definitions from boolean arrays
            if(favorites[mealCounter] == true){
                favorite.setSelected(true);
            }
            else{
                favorite.setSelected(false);
            }
            //get checkBox definitions from boolean arrays
            if(dislikes[mealCounter] == true){
                dislike.setSelected(true);
            }
            else{
                dislike.setSelected(false);
            }
        }
    }
    
    /**Method for dislike button
     @param event*/
    public void dislikeOnAction(ActionEvent event){
        //when meal is disliked make sure favorite is not selected
        if(dislike.isSelected()){
            if(favorite.isSelected()){
                favorite.setSelected(false);
                favoriteOnAction(event);
                favorites[mealCounter] = false;
            }
            
            //add dislike
            Meal tempMeal = generatedMeals.get(mealCounter);
            String mealName = tempMeal.getMealName();
            DataHub.users.get(indexOfCurrent).addDislike(mealName);
            dislikes[mealCounter] = true;
        }
        else{
            //remove dislike
            Meal tempMeal = generatedMeals.get(mealCounter);
            String mealName = tempMeal.getMealName();
            DataHub.users.get(indexOfCurrent).removeDislike(mealName);
            dislikes[mealCounter] = false;
        }
    }
    
    /**Method for Favorite button
     @param event*/
    public void favoriteOnAction(ActionEvent event){
        //Check if dislike is selected
        if(favorite.isSelected()){
            if(dislike.isSelected()){
                dislike.setSelected(false);
                dislikeOnAction(event);
                dislikes[mealCounter] = false;
            }
            
            //Add favorite
            Meal tempMeal = generatedMeals.get(mealCounter);
            String mealName = tempMeal.getMealName();
            DataHub.users.get(indexOfCurrent).addFavorite(mealName);
            favorites[mealCounter] = true;
        }
        else{
            //remove favorite
            Meal tempMeal = generatedMeals.get(mealCounter);
            String mealName = tempMeal.getMealName();
            DataHub.users.get(indexOfCurrent).removeFavorite(mealName);
            favorites[mealCounter] = false;
            
        }
    }
    
    /**Method to return to main menu
     @param event
     @throws java.io.IOException*/
    public void backToMainOnAction(ActionEvent event) throws IOException{
        //open main menu scene
        Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene newScene = new Scene(secondView);
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(newScene);
    }
    
    /**Method to return to Meal generator
     @param event
     @throws java.io.IOException*/
    public void backToGenOnAction(ActionEvent event) throws IOException{
        //open meal gen scene
        Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("MealGen.fxml"));
        Scene newScene = new Scene(secondView);
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(newScene);      
    }
    
    /**Method to set boolean arrays to all false*/
    public void setChecksToFalse(){
        for(int i = 0; i < generatedMeals.size(); i++){
            dislikes[i] = false;
            favorites[i] = false;
        }
    }
}
