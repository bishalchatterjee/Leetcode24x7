//Using floyd warshall to precompute the multi source shortest path array
//Can aslo be done using dijkstra for very node and then compute
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMatrix = buildGraphAdjMatrix(edges, n);

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i==j){
                        adjMatrix[i][j]=0;
                        continue;
                    }else if (i != j && adjMatrix[i][k] != Integer.MAX_VALUE && adjMatrix[k][j] != Integer.MAX_VALUE) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }
        }

        int minThresholdForCity = Integer.MAX_VALUE;
        int cityIndex = -1;

        for (int i = 0; i < n; i++) {
            int currCountOfPathUnderThreshold = 0;
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] <= distanceThreshold) {
                    currCountOfPathUnderThreshold++;
                }
            }

            if (currCountOfPathUnderThreshold <= minThresholdForCity) {
                minThresholdForCity = currCountOfPathUnderThreshold;
                cityIndex = i;
            }
        }

        return cityIndex;
    }

    private int[][] buildGraphAdjMatrix(int[][] edges, int V) {
        int[][] adjMatrix = new int[V][V];

        // Initialize the matrix with maximum values
        for (int i = 0; i < V; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
        }

        for (int[] edge : edges) {
            adjMatrix[edge[0]][edge[1]] = edge[2];
            adjMatrix[edge[1]][edge[0]] = edge[2];
        }

        return adjMatrix;
    }
}
