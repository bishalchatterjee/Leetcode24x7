class DisjointSet {
    int[] size; // stores size of each component
    int[] parent; // stores parent of each component

    DisjointSet(int n) {
        size = new int[n + 1]; // n+1 so that it will work for both 0 based indexing and 1 based indexing
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            size[i] = 1; // size of all componenets are 1 at the beginning as single nodes are considired
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
            return; // they belong to the same component (have same ultimate parent)

        if (size[ultimateParentOfU] < size[ultimateParentOfV]) {// attach smaller to the bigger component
            parent[ultimateParentOfU] = ultimateParentOfV;
            size[ultimateParentOfV] += size[ultimateParentOfU];
        } else if (size[ultimateParentOfV] < size[ultimateParentOfU]) {
            parent[ultimateParentOfV] = ultimateParentOfU;
            size[ultimateParentOfU] += size[ultimateParentOfV];
        } else if (size[ultimateParentOfV] == size[ultimateParentOfU]) { // if both are of same rank attach to either of
                                                                         // themself and increase the rank of choosen
                                                                         // one by 1
            parent[ultimateParentOfV] = ultimateParentOfU;
            size[ultimateParentOfU] += size[ultimateParentOfV];
        }
    }
}

class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int n = rows * cols;

        DisjointSet ds = new DisjointSet(n);

        // Mapping 2D grid to 1D
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // Union with other servers in the same row
                    for (int k = 0; k < cols; k++) {
                        if (grid[r][k] == 1 && k != c) {
                            ds.unionBySize(r * cols + c + 1, r * cols + k + 1);
                        }
                    }
                    // Union with other servers in the same column
                    for (int k = 0; k < rows; k++) {
                        if (grid[k][c] == 1 && k != r) {
                            ds.unionBySize(r * cols + c + 1, k * cols + c + 1);
                        }
                    }
                }
            }
        }

        // Count the number of servers that can communicate
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && ds.size[ds.findUltimateParent(i * cols + j + 1)] > 1) {
                    count++;
                }
            }
        }

        return count;
    }
}