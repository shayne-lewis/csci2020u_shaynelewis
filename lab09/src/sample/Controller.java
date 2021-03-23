package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Controller {
    @FXML private Canvas mainCanvas;
    @FXML private GraphicsContext gc;

    private List<String[]> googleData = new ArrayList<String[]>();
    private List<String[]> appleData = new ArrayList<String[]>();
    private ArrayList<Float> googleClose = new ArrayList<>();
    private ArrayList<Float> appleClose = new ArrayList<>();

    @FXML public void initialize(){
        gc = mainCanvas.getGraphicsContext2D();
        downloadStockPrices();
        closeGoogle();
        closeApple();
        drawLinePlot(googleData, appleData);
    }

    //gets list of columns with values
    public void downloadStockPrices(){
        try{
            //GOOGLE
            String sURL = "https://query1.finance.yahoo.com/v7/finance/download/GOOG?period1=" +
                    "1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true";
            URL netURL = new URL(sURL);

            URLConnection conn = netURL.openConnection();
            conn.setDoOutput(false);
            conn.setDoInput(true);

            InputStream inStream = conn.getInputStream();
            Scanner s = new Scanner(inStream);
            while(s.hasNext()){
                String line = s.nextLine();
                String[] columns = line.split(",");
                googleData.add(columns);
            }

            //APPLE
            String sURL2 = "https://query1.finance.yahoo.com/v7/finance/download/AAPL?period1=" +
                    "1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true";
            URL netURL2 = new URL(sURL2);

            URLConnection conn2 = netURL2.openConnection();
            conn2.setDoOutput(false);
            conn2.setDoInput(true);

            InputStream inStream2 = conn2.getInputStream();
            Scanner s2 = new Scanner(inStream2);
            while(s2.hasNext()){
                String line2 = s2.nextLine();
                String[] columns2 = line2.split(",");
                appleData.add(columns2);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //adds close float values to an array list for google
    public void closeGoogle(){
        boolean firstLine = true;
        for(int i = 0; i < googleData.size(); i++){
            if(!firstLine){
                googleClose.add(Float.valueOf(googleData.get(i)[4]));
            }
            else{
                firstLine = false;
            }
        }
    }

    //adds close float values to an array list for apple
    public void closeApple(){
        boolean firstLine = true;
        for(int i = 0; i < appleData.size(); i++){
            if(!firstLine){
                appleClose.add(Float.valueOf(appleData.get(i)[4]));
            }
            else{
                firstLine = false;
            }
        }
    }

    //makes axis and plots using lines
    public void drawLinePlot(List googleData, List appleData){
        //x and y axis
        gc.setStroke(Color.BLACK);
        gc.strokeLine(0, 50, 0, 950);
        gc.strokeLine(0, 950, 800, 950);

        gc.setStroke(Color.RED);
        double x = 0;
        double y = 950;
        for(int i = 0; i < googleClose.size(); i++){
            try{
                plotLine(x,y - googleClose.get(i) + 50,x + 10,y - googleClose.get(i+1) + 50);
            }
            catch(IndexOutOfBoundsException e){
                //e.printStackTrace();
            }
            x += 10;
        }

        //line plot apple
        double x2 = 0;
        double y2 = 900;
        gc.setStroke(Color.BLUE);
        for(int i = 0; i < appleClose.size(); i++){
            try{
                plotLine(x2,y2 - appleClose.get(i) + 50,x2 + 10,y2 - appleClose.get(i+1) + 50);
            }
            catch(IndexOutOfBoundsException e){
                //e.printStackTrace();
            }
            x2 += 10;
        }
    }

    //draws a line
    public void plotLine(double x, double y, double xx, double yy ){
        gc.strokeLine(x,y,xx,yy);
    }
}
