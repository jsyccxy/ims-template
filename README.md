The K-means algorithm is a very common unsupervised clustering method. It is necessary to first determine the number of clusters, that is, the K value. After determining the number of clusters, K cluster centers are then initialized, and the data samples are assigned to the clusters represented by their nearest centroids by calculating the distance of each data sample from each centroid. After all points are assigned to the K-cluster, the arithmetic mean of all the data points in each cluster (this is a method) is calculated as the new centroid. Iterate over, calculate the distance and re-divide the data. Constant iterations, until we reach the number of iterations we define, end the iteration, and output the results of each cluster.


K-Means algorithm steps:

    1. Initialize the number K of clusters and randomly select K cluster centers.
    
    2. Repeat the following steps until the cluster center no longer changes:
    
        a. Calculate the distance from each data sample to the cluster center and divide the data samples into the nearest cluster.
        
        b. Calculate the mean of each dimension of all data in each cluster as the new cluster center for each cluster.
        
    3. Output the data samples gathered by each cluster.
    
    
the distance we calculated is Euclidean Distance:

![image text](https://github.com/jsyccxy/ims-template/blob/master/img-folder/caldis.png)

To read the wifigdansk.csv file, firstly i tried to used the opencsv.jar, but when i runthe code , it shows a problem that:
   The first line of the wifigdansk.csv file is "?54.382059", and because of this kind of problem, my kmeans code cannot work 
   properly. so I learned from my college Luckson's csvread file,  the code read the file devided by ",", and for the third anf fourth column, the third column is the x coordinate and the fourth column is y coordinate.
   
   in my code, i set a random center point first:
   
   ![image text](https://github.com/jsyccxy/ims-template/blob/master/img-folder/initial.png)
   
   after set the initial point , we have to calculate the distance of other points in the cluster :
   
   ![image text](https://github.com/jsyccxy/ims-template/blob/master/img-folder/distan.png)
   
   then after calculate the distance, find the mean value of the distance value and set the mean vale as the new center point:
   
   ![image text](https://github.com/jsyccxy/ims-template/blob/master/img-folder/new.png)
   
   when the code finish the iteration, or the error is small than we set, print the result of the code:
   
   ![image text](https://github.com/jsyccxy/ims-template/blob/master/img-folder/print.png)
   
   After running the test code, we can use the jmathpolt.jar to draw all the clusters :
   
   ![image text](https://github.com/jsyccxy/ims-template/blob/master/img-folder/picture.png)
   
   
