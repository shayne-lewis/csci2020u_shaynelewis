package sample;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FileLoader {
    private String filename;
    private int totalWords = 0;
    private Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
    private Map<String, Double> percentCounts = new TreeMap<String, Double>();

    public Map<String, Double> getPercentCounts() {
        return percentCounts;
    }

    public FileLoader(String filename){
        this.filename = filename;
    }

    public void loadFile(){
        String line = "";

        try{
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            while ((line = br.readLine())!=null){
                String[] columns = line.split(",");
                //System.out.println(line);
                if(wordCounts.containsKey(columns[5])){
                    int prevValue = wordCounts.get(columns[5]);
                    wordCounts.put(columns[5], prevValue + 1);
                } else {
                    wordCounts.put(columns[5], 1);
                }

                totalWords++;
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        percentMapping();
    }

    public void percentMapping(){
        for(Map.Entry<String, Integer> entry : wordCounts.entrySet()){
            String name = entry.getKey();
            Double val = new Double(entry.getValue());
            percentCounts.put(name, (val / totalWords));
        }
    }
}
