package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Controller for main menu

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController implements Initializable {


    //Initialize FXML fields
    @FXML
    private Label username;


    /**Override for initialize, get current user
     @param url
     @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        int index = DataHub.getIndexOfCurrentUser();
        username.setText("User: " + DataHub.users.get(index).getUsername());
    }

    /**Method to launch Meal gen scene
     @param event
     @throws java.io.IOException
     */
    public void createRandomMealButtonOnAction(ActionEvent event) throws IOException {
            Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("MealGen.fxml"));
            Scene newScene = new Scene(secondView);
            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
    }

     /**Method to launch Locations scene
     @param event
     @throws java.io.IOException
     */
    public void locationsButtonOnAction(ActionEvent event) throws IOException {
        Parent secondView;
	secondView = (Parent) FXMLLoader.load(getClass().getResource("Locations.fxml"));
	Scene newScene = new Scene(secondView);
	Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();	
	currentStage.setScene(newScene);

    }

    /**Method to launch favorites scene
     @param event
     @throws java.io.IOException
     */
    public void checkUserFavoritesButtonOnAction(ActionEvent event) throws IOException{
        Parent secondView;
	secondView = (Parent) FXMLLoader.load(getClass().getResource("Favorites.fxml"));	
	Scene newScene = new Scene(secondView);	
	Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();	
	currentStage.setScene(newScene);
    }

    /**Method to launch Login scene
     @param event
     @throws java.io.IOException
     */
    public void logoutButtonOnAction(ActionEvent event) throws IOException {
        Parent secondView;
	secondView = (Parent) FXMLLoader.load(getClass().getResource("Login.fxml"));
	Scene newScene = new Scene(secondView);
	Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
	currentStage.setScene(newScene);
    }
    

}
