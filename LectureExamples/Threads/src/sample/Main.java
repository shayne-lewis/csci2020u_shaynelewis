package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        //add UI elements to control the inputs for the client to replace the ChatServClient.run



        primaryStage.show();
        ChatServerClient client = new ChatServerClient();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
