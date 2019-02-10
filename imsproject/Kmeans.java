package imsproject;

import java.util.List;
import java.util.Random;
import org.apache.commons.collections4.map.MultiValueMap;
import imsproject.CSVDoc;
import imsproject.Point;

public class Kmeans {

	public Point[] Centroid = null;
    public Point[] useless = null;
    
    private double randomnum(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
    private Point[] firstCentroids(int k) {
        Point[] rndPoints = new Point[k];
        for (int i = 0; i < k; i++) {
            Point point = new Point();
            double x = randomnum(CSVDoc.dolimitX, CSVDoc.uplimitX);
            double y = randomnum(CSVDoc.dolimitY, CSVDoc.uplimitY);
            point.setX(x);
            point.setY(y);
            rndPoints[i] = point;
        }
        return rndPoints;
    }
    
    private MultiValueMap<Integer, Point> placePointInCentroid(Point[] Centroids, List<Point> wifiGeoPoints) {
        MultiValueMap<Integer, Point> clustersList = new MultiValueMap<>();
        for (Point point : wifiGeoPoints) {
            double minDistance = 2000.0;
            int selectedCentroid = 0;
            for (int i = 0; i < Centroids.length; i++) {
                double distance = caldistance(Centroids[i], point);
                if (distance < minDistance) {
                    minDistance = distance;
                    selectedCentroid = i;
                }
            }
            clustersList.put(selectedCentroid, point);
        }
        return clustersList;
    }
    
    public Point meanvalue(int key, MultiValueMap<Integer, Point> clustersList) {
        Point newPoints = new Point();
        double sumX = 0.0;
        double sumY = 0.0;
        double averageX = 0.0;
        double averageY = 0.0;
        int lstSize = 0;

        List<Point> list;
        list = (List) clustersList.get(key);
        lstSize = list.size();
        for (int j = 0; j < lstSize; j++) {
            sumX = sumX + list.get(j).getX();
            sumY = sumY + list.get(j).getY();
        }
        averageX = sumX / lstSize;
        averageY = sumY / lstSize;
        newPoints.setX(averageX);
        newPoints.setY(averageY);
        return newPoints;
    }
    
    public Point[] newpoint(int k, MultiValueMap<Integer, Point> clustersList) {
        Point[] newPoints = new Point[k];
        for (int i = 0; i < k; i++) {
            newPoints[i] = meanvalue(i, clustersList);
        }
        return newPoints;
    }
    
    private double caldistance(Point point1, Point point2) {
        double distance;
        distance = Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
        return distance;
    }
    
    public MultiValueMap<Integer, Point> clusterData(int k, List<Point> wifiGeoPoints, int iterations,double err) {
    	Centroid = firstCentroids(k);
        MultiValueMap<Integer, Point> clustersList = placePointInCentroid(Centroid, wifiGeoPoints);
        while(clustersList.size()!=k){
            Centroid = firstCentroids(k); 
            clustersList = placePointInCentroid(Centroid, wifiGeoPoints);   
        }
        useless=Centroid;
        for (int i = 0; i < iterations; i++) {
        	Centroid = newpoint(k, clustersList);
            clustersList = placePointInCentroid(Centroid, wifiGeoPoints);
            useless=Centroid;   
        }
        for (int x = 0; x < Centroid.length; x++) {
            System.out.println("[" + Centroid[x].getX() + "," + Centroid[x].getY() + "]");
        }
        return clustersList;
}
}
