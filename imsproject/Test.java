package imsproject;

import imsproject.CSVDoc;
import java.util.List;
import javax.swing.JFrame;
import org.apache.commons.collections4.map.MultiValueMap;
import org.math.plot.*;
import imsproject.Kmeans;
import imsproject.Point;

public class Test {
    public static double[] x;
    public static double[] y;
    public static void main(String[] args) {
        int k = 3;
        double err=0.00001;
        int iterations = 50;
        CSVDoc doc = new CSVDoc();
        String filename = "src/main/resources/wifigdansk.csv";
        doc.readCSV(filename);
        x = doc.getX().stream().mapToDouble(Double::doubleValue).toArray();
        y = doc.getY().stream().mapToDouble(Double::doubleValue).toArray();
        plotGraph(x, y);
        MultiValueMap<Integer, Point> clustersList;
        Kmeans kmean = new Kmeans();
        clustersList = kmean.clusterData(k, doc.getPoints(), iterations,err);
        List<Point> list;
        int lstSize = 0;
        Plot2DPanel plot = new Plot2DPanel();
        
        for (int key = 0; key < k; key++) {
            list = (List) clustersList.get(key);
            lstSize = list.size();
            x=new double[lstSize];
            y=new double[lstSize];
            for (int j = 0; j < lstSize; j++) {
                x[j] =  list.get(j).getX();
                y[j] =  list.get(j).getY();
            }    
       plot.addScatterPlot("Class "+key, x, y);
        }
        JFrame frame = new JFrame("Class");
        frame.setSize(1000, 1000);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }

    public static void plotGraph(double[] x, double[] y) {
        Plot2DPanel plot = new Plot2DPanel();
        plot.addScatterPlot("wifigdansk", x, y);
        JFrame frame = new JFrame("wifigdansk");
        frame.setSize(1000, 1000);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }
}
