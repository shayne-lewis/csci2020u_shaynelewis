package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn studentID;
    @FXML
    private TableColumn midterm;
    @FXML
    private TableColumn assignments;
    @FXML
    private TableColumn finalExam;
    @FXML
    private TableColumn finalMark;
    @FXML
    private TableColumn letterGrade;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fileHeader;
    @FXML
    private MenuItem newFile;
    @FXML
    private MenuItem open;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem saveAs;
    @FXML
    private MenuItem exit;

    public String currentFilename = "";

    @FXML
    public void initialize(){
        studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        midterm.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        assignments.setCellValueFactory(new PropertyValueFactory<>("assignments"));
        finalExam.setCellValueFactory(new PropertyValueFactory<>("finalExam"));
        letterGrade.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));
        finalMark.setCellValueFactory(new PropertyValueFactory<>("finalMark"));

        tableView.setItems(DataSource.getAllMarks());
    }

    @FXML
    public void newFileClicked(Event e){
        tableView.getItems().clear();
    }

    @FXML
    public void exitClicked(Event e){
        System.exit(0);
    }

    @FXML
    public void openClicked(Event e){
        FileChooser fileChoose = new FileChooser();
        fileChoose.setInitialDirectory(new File("."));
        Stage dialog = new Stage();
        File file = fileChoose.showOpenDialog(dialog);
        FileLoader fl = new FileLoader(file.getAbsolutePath());
        fl.loadFile();
        tableView.setItems(fl.getData());
        currentFilename = file.getName();
        //System.out.println(currentFilename);
    }

    @FXML
    public void saveClicked(Event e){
        StudentRecord record;
        List <List<String>> arrList = new ArrayList<>();
        for (int i = 0; i < tableView.getItems().size(); i++){
            record = (StudentRecord) tableView.getItems().get(i);
            arrList.add(new ArrayList<>());
            arrList.get(i).add(record.getStudentID());
            arrList.get(i).add(String.valueOf(record.getAssignments()));
            arrList.get(i).add(String.valueOf(record.getMidterm()));
            arrList.get(i).add(String.valueOf(record.getFinalExam()));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrList.size(); i++){
            for (int j = 0; j < arrList.get(i).size(); j++){
                //System.out.println(arrList.get(i).get(j));
                sb.append(arrList.get(i).get(j));
                sb.append(',');
            }
            sb.append('\n');
        }
        try (PrintWriter pw = new PrintWriter(new File(currentFilename))){
            pw.append(sb.toString());
        }
        catch (FileNotFoundException err){
            err.printStackTrace();
        }
    }

    @FXML
    public void saveAsClicked(Event e){
        StudentRecord record;
        List <List<String>> arrList = new ArrayList<>();
        for (int i = 0; i < tableView.getItems().size(); i++){
            record = (StudentRecord) tableView.getItems().get(i);
            arrList.add(new ArrayList<>());
            arrList.get(i).add(record.getStudentID());
            arrList.get(i).add(String.valueOf(record.getAssignments()));
            arrList.get(i).add(String.valueOf(record.getMidterm()));
            arrList.get(i).add(String.valueOf(record.getFinalExam()));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrList.size(); i++){
            for (int j = 0; j < arrList.get(i).size(); j++){
                //System.out.println(arrList.get(i).get(j));
                sb.append(arrList.get(i).get(j));
                sb.append(',');
            }
            sb.append('\n');
        }
        // can name file anything
        try (PrintWriter pw = new PrintWriter(new File("savedAsFile.csv"))){
            pw.append(sb.toString());
        }
        catch (FileNotFoundException err){
            err.printStackTrace();
        }
        FileChooser fileChoose = new FileChooser();
        fileChoose.setInitialDirectory(new File("."));
        Stage dialog = new Stage();
        File file = fileChoose.showOpenDialog(dialog);
        fileChoose.setInitialFileName(currentFilename);
    }
}
