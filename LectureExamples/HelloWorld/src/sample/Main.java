package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



import static java.awt.Font.*;
import static javafx.scene.text.Font.font;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World - Module 4");

//        Creating layout gridpane
        GridPane myGrid = new GridPane();
        myGrid.setAlignment(Pos.CENTER);
        myGrid.setHgap(10);
        myGrid.setVgap(10);
        myGrid.setPadding(new Insets(25, 25, 25, 25));



//        Create login UI controls
//        --- Title Welcome
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(font("Tahoma", FontWeight.NORMAL, 20));
// -- labels
        Label lbUserName = new Label("Username:");
        Label lbPassword = new Label("Password:");
// -- inputs
        TextField txUserName = new TextField();
        PasswordField psPassword = new PasswordField();
//        -- Button
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
//        -- link
        final Text actionTarget = new Text();



//        Add the components onto the myGrid pane
        myGrid.add(sceneTitle, 0,0,2,1);
        myGrid.add(lbUserName, 0,1);
        myGrid.add(txUserName, 1,1);
        myGrid.add(lbPassword, 0,2);
        myGrid.add(psPassword, 1,2);
        myGrid.add(hbBtn, 1, 4);
        myGrid.add(actionTarget, 1, 6);

//        Setting the btn event
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Sign in button pressed");
            }
        });


//        Creating myScene with custom layout
        Scene myScene = new Scene(myGrid, 300,275);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
