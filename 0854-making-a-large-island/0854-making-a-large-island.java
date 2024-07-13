class DisjointSet {
    int[] size; // stores size of each component
    int[] parent; // stores parent of each component

    DisjointSet(int n) {
        size = new int[n + 1]; // n+1 so that it will work for both 0 based indexing and 1 based indexing
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            size[i] = 1; // size of all components are 1 at the beginning as single nodes are considered
            // to be independent component
            parent[i] = i; // all are parent of itself
        }
    }

    int findUltimateParent(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = findUltimateParent(parent[x]); // Path Compression
    }

    void unionBySize(int u, int v) {
        int ultimateParentOfU = findUltimateParent(u);
        int ultimateParentOfV = findUltimateParent(v);

        if (ultimateParentOfU == ultimateParentOfV)
            return; // they belong to the same component (have the same ultimate parent)

        if (size[ultimateParentOfU] < size[ultimateParentOfV]) { // attach smaller to the bigger component
            parent[ultimateParentOfU] = ultimateParentOfV;
            size[ultimateParentOfV] += size[ultimateParentOfU];
        } else if (size[ultimateParentOfV] < size[ultimateParentOfU]) {
            parent[ultimateParentOfV] = ultimateParentOfU;
            size[ultimateParentOfU] += size[ultimateParentOfV];
        } else { // if both are of the same size, attach to either of them and increase the size of the chosen one
            parent[ultimateParentOfV] = ultimateParentOfU;
            size[ultimateParentOfU] += size[ultimateParentOfV];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        int totalNodes = n * n;

        DisjointSet ds = new DisjointSet(totalNodes); //Since the graph is changing dynamically use DSU

        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        //Step 1: Connect the components(Union the connected ones)
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0) continue;

                if(grid[row][col] == 1){

                    for(int i = 0; i < 4; i++){
                        int newRow = row + dir[i][0];
                        int newCol = col + dir[i][1];

                        if(isValid(grid, newRow, newCol) && grid[newRow][newCol] == 1){
                            int currNode = row * n + col;
                            int adjacentNode = newRow * n + newCol;
                            ds.unionBySize(currNode, adjacentNode);
                        }
                    }
                } 
            }
        }

        //Step 2: Once union is done now change one cell from 0 to 1, and count the new connected component size
        int maxSize = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1) continue; //Aleady 1 so skip

                if(grid[row][col] == 0){ //try changing this to 1
                    Set<Integer> components = new HashSet<>(); //stores the ultimate parent of a component, avoids adding valid cells but with same ultimate parent
                    for(int i = 0; i < 4; i++){
                        int newRow = row + dir[i][0];
                        int newCol = col + dir[i][1];

                        if(isValid(grid, newRow, newCol) && grid[newRow][newCol] == 1){
                            int currNode = newRow * n + newCol;
                            components.add(ds.findUltimateParent(currNode));
                        }
                    }

                    int totalSizeOfNewComponent = 0;
                    for(int parent : components){
                        totalSizeOfNewComponent += ds.size[parent];
                    }
                    maxSize = Math.max(maxSize, totalSizeOfNewComponent + 1);
                } 
            }
        }

        for(int node = 0; node < totalNodes; node++){
            maxSize = Math.max(maxSize, ds.size[ds.findUltimateParent(node)]);
        }

        return maxSize;
    }
    private boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length; 
    }
}