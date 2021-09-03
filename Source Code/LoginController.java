package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Controller for login scene

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class LoginController implements Initializable {
    //Initialize necessary fields
    @FXML
    private Label invalidLoginLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    /**Method to define what login button will do when clicked*/
    public void loginButtonOnAction(ActionEvent event) throws IOException {
        //get users
        ArrayList<User> users = DataHub.getUsers();
        //define temporary user object
        User tempUser;
        //get user inputs
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        //increment through users list to see if user input matches any objects
        //within the users list
        for(int i = 0; i < users.size(); i++){
            tempUser = users.get(i);    //get user from list
            //test if username and password are same as user input
            if(tempUser.getUsername().equals(username) && tempUser.getPassword().equals(password)){
                //if login is valid set current user to tempUser and open main menu
                DataHub.setIndexOfCurrentUser(i);
                openMainMenuScene(event);
            }
        }
        //if user is not found, display error
        invalidLoginLabel.setText("Invalid Username or Password");
    }

    /**Method to change to register scene when button is clicked
     @param event, event of button being clicked*/
    public void registerButtonOnAction(ActionEvent event) throws IOException {
        //open register scene
      Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("Register.fxml"));
      Scene newScene = new Scene(secondView);
      Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
      currentStage.setScene(newScene);
    }

    /**Override method for initialize*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    
    //Registration Menu
    private Scene registerScene;

    public void setRegisterScene(Scene scene) {
        registerScene = scene;
    }

    public void openRegisterScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(registerScene);
    }

    /**Method to open main menu
     @param event, when button is clicked to change scene*/
    public void openMainMenuScene(ActionEvent actionEvent) throws IOException{
        try{
            Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene newScene = new Scene(secondView);
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        catch(IOException e){
            System.out.println("Main Menu Scene not found");
        }
    }
}
