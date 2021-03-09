package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;

import java.util.Map;
import java.util.TreeMap;

public class Controller {
    @FXML private Canvas mainCanvas;
    @FXML private GraphicsContext gc;
    private FileLoader file = new FileLoader("weatherwarnings-2015.csv");
    private static Color[] pieColours = { Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};

    @FXML public void initialize(){
        gc = mainCanvas.getGraphicsContext2D();
        file.loadFile();
        drawPie(150, 50, file.getPercentCounts(), pieColours);
    }


    public void drawPie(int x, int y, Map<String, Double> percentCounts, Color[] colors){
        int i = 0;
        int a = 50;
        double startAng = 0;
        for(Map.Entry<String, Double> entry : file.getPercentCounts().entrySet()){
            gc.setFill(colors[i]);
            i++;
            double endAng = startAng + entry.getValue() * 360;
            System.out.println("startAngle = " + startAng + "\n endAngle = " + endAng);
            gc.fillArc(x+200, y,200,200,startAng,endAng - startAng, ArcType.ROUND);
            startAng = endAng;
            gc.fillRect(x-30, a+10, 20, 10);
            gc.setFill(Color.BLACK);
            gc.fillText(entry.getKey(),x,a+20);
            a += 30;
        }
    }
}
