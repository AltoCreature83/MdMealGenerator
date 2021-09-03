package sample;
// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Main for meal generator program

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // getting loader and a pane for the first scene.
        // loader will then give a possibility to get related controller
        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent loginPane = firstPaneLoader.load();
        Scene loginScene = new Scene(loginPane, 520, 400);

        primaryStage.setTitle("McDonald's Meal Generator");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        //initialize necessary data
        DataHub.createUsers();
        DataHub.createMeals();
        DataHub.createDinnersAndBreakfasts();
        DataHub.createLocations();

        //launch program
        launch(args);

        //export users when program is completed
        ArrayList<User> users = DataHub.getUsers();
        DataHub.exportUsers(users);


    }
}