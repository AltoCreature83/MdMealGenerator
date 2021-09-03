package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Favorites controller for favorites scene

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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**Class to control favorites scene*/
public class FavoritesController implements Initializable {
    //initialize global counter and favorites array
    public static ArrayList<Meal> favorites;
    public static int favCounter = 0;
       
    //initialize fx fields
    @FXML
    private ImageView imageview;
    
    @FXML
    private ListView mealInfo;
    
    @FXML
    private Button viewNext;
    
    @FXML
    private Button clearFav;
    
    @FXML
    private Button removeFav;
    
    @FXML
    private Button viewPrevious;
    
    @FXML
    private Label noFavorites;
    
    @FXML
    private Label warning;
    
    /**Override for initialize*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //when scene opens set view next to invisible
        viewNext.setVisible(false);
        viewPrevious.setVisible(false);
        clearFav.setVisible(false);
        removeFav.setVisible(false);
        
        //get current user favorites list
        int index = DataHub.getIndexOfCurrentUser();
        User temp = DataHub.users.get(index);
        DataHub.createFavorites(temp);
        favorites = DataHub.getFavoriteMeals();
        
        //if favorites list is populated display favorites
        if(favorites.size() > 0){
            //get buttons
            clearFav.setVisible(true);

            
            //get image
            Meal firstMeal = favorites.get(0);
            Image firstImage = new Image(firstMeal.getMealIcon());
            imageview.setImage(firstImage);
            
            //get meal info
            String info = firstMeal.toString();
            String outOf = ("Displaying favorite\n 1 out of " + favorites.size());
            mealInfo.getItems().setAll(info, outOf);
            
            //if there are more than one item in favorites, display view next button
            if(favorites.size() > 1){
            viewNext.setVisible(true);
            removeFav.setVisible(true);
            }
        }
        //if favorites is not populated display error
        else{
            noFavorites.setText("No Favorites Available, Please Return To Main Menu");
        }
    } 
    
    /**Method to show next favorite meal
    @param event
    @throws java.io.IOException*/
    public void NextFavButtonOnAction(ActionEvent event){
        //if counter is less than list size, display next item
        if(favCounter < favorites.size() - 1){
            viewPrevious.setVisible(true);//display previous button
            favCounter++;//increment counter
            
            //get meal icon
            Meal tempMeal = favorites.get(favCounter);
            Image tempImage = new Image(tempMeal.getMealIcon());
            imageview.setImage(tempImage);
            
            //get meal info
            String info = tempMeal.toString();
            String outOf = ("Displaying favorite\n"+ (favCounter + 1) + " out of " + favorites.size());
            mealInfo.getItems().setAll(info, outOf);
            
            //if at end of list, set viewNext to invisible
            if(favCounter == favorites.size() - 1){
                viewNext.setVisible(false);
            } 
        }
    }
    
    /**Method to define what previous button does when pressed
     @param event*/
    public void viewPrevFavOnAction(ActionEvent event){
        //if counter is greater than zero display previous item
        if(favCounter > 0){
            //set next to visible
            viewNext.setVisible(true);
            favCounter--;//decrement counter
            
            //get meal icon
            Meal tempMeal = favorites.get(favCounter);
            Image tempImage = new Image(tempMeal.getMealIcon());
            imageview.setImage(tempImage);
            
            //get meal info
            String info = tempMeal.toString();
            String outOf = ("Displaying favorite\n"+ (favCounter + 1) + " out of " + favorites.size());
            mealInfo.getItems().setAll(info, outOf);
            
            //if at start of list set previous button to invisible
            if(favCounter == 0){
                viewPrevious.setVisible(false);
            } 
        }
    }
    
    /**Method to remove item from favorite
     @param event*/
    public void removeFavOnAction(ActionEvent event){
        //get user, get meal name, remove mealName from user favorites
        int index = DataHub.getIndexOfCurrentUser();
        String tempName = favorites.get(favCounter).getMealName();
        DataHub.users.get(index).removeFavorite(tempName);
        warning.setText("Removed, reload page for changes to take effect");
    }
    /**method to clear favorites
    @param event
    @throws java.io.IOException*/ 
    public void clearFavOnAction(ActionEvent event) throws IOException{
        //get user, clear user favorites
        int index = DataHub.getIndexOfCurrentUser();
        DataHub.users.get(index).clearFavorites();
        backButtonOnAction(event);
    }
    
    /**Method to return to main menu when button is push
    @param event
    @throws java.io.IOException*/
    public void backButtonOnAction(ActionEvent event) throws IOException{
        DataHub.favorites.clear();
        favorites.clear();
        Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene newScene = new Scene(secondView);
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(newScene);
    }
}

