The K-means algorithm is a very common unsupervised clustering method. It is necessary to first determine the number of clusters, that is, the K value. After determining the number of clusters, K cluster centers are then initialized, and the data samples are assigned to the clusters represented by their nearest centroids by calculating the distance of each data sample from each centroid. After all points are assigned to the K-cluster, the arithmetic mean of all the data points in each cluster (this is a method) is calculated as the new centroid. Iterate over, calculate the distance and re-divide the data. Constant iterations, until we reach the number of iterations we define, end the iteration, and output the results of each cluster.


K-Means algorithm steps:
    1. Initialize the number K of clusters and randomly select K cluster centers.
    2. Repeat the following steps until the cluster center no longer changes:
        a. Calculate the distance from each data sample to the cluster center and divide the data samples into the nearest cluster.
        b. Calculate the mean of each dimension of all data in each cluster as the new cluster center for each cluster.
    3. Output the data samples gathered by each cluster.
    
    
    the distance i calculated is the Euclidean Distance:
        ![image text](https://github.com/jsyccxy/ims-template/blob/master/img-folder/caldis.png)
    
    




