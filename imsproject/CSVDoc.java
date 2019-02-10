package imsproject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVDoc {
	    private List<Double> wifiX = new ArrayList<>();
	    private List<Double> wifiY = new ArrayList<>();
	    private List<Point> wifiPoints = new ArrayList<>();
	    public static double uplimitX = 1000;
	    public static double dolimitX = 0;
	    public static double uplimitY = 1000;
	    public static double dolimitY = 0;

	    public void readCSV(String filename) {
	        File file = new File(filename);

	        List<String> lines = null;
	        try {
	            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
	            for (String line : lines) {
	                Point point = new Point();
	                String[] array = line.split(";");
	                String[] linetext = array[0].split(",");
	                if (!linetext[2].toString().equals("x")) {
	                    wifiX.add(Double.parseDouble(linetext[2].toString()));
	                    wifiY.add(Double.parseDouble(linetext[3].toString()));
	                    point.setX(Double.parseDouble(linetext[2].toString()));
	                    point.setY(Double.parseDouble(linetext[3].toString()));
	                    wifiPoints.add(point);
	                    if (Double.parseDouble(linetext[2].toString()) < uplimitX) {
	                    	uplimitX = Double.parseDouble(linetext[2].toString());
	                    } else if (Double.parseDouble(linetext[2].toString()) > dolimitX) {
	                    	dolimitX = Double.parseDouble(linetext[2].toString());
	                    } else if (Double.parseDouble(linetext[3].toString()) < uplimitY) {
	                    	uplimitY = Double.parseDouble(linetext[3].toString());
	                    } else if (Double.parseDouble(linetext[3].toString()) > dolimitY) {
	                    	dolimitY = Double.parseDouble(linetext[3].toString());
	                    }
	                }
	            }
	        } catch (IOException ex) {
	            Logger.getLogger(CSVDoc.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    public List<Double> getX() {
	        return wifiX;
	    }
	    public List<Double> getY() {
	        return wifiY;
	    }
	    public List<Point> getPoints() {
	        return wifiPoints;
	    }
	}
