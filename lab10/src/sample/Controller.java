package sample;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Controller {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField messageField;
    @FXML
    private TextField serverField;

    @FXML
    public void initialize(){

    }

    @FXML
    public void setServerField(String message){
        serverField.setText(serverField.getText() + "\n" + message);
    }
    @FXML
    public void sendMessage() throws IOException{
        String message = usernameField.getText() + ": " + messageField.getText();
        var socket = new Socket("localhost", 47293);
        var pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println(message);
        pw.flush();
    }

    @FXML
    public void exitClient(){
        System.exit(0);
    }
}
