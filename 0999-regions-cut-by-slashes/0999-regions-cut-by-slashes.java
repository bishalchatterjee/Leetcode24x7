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
        } else { // if both are of the same size, attach to either of them and increase the size
                 // of the chosen one
            parent[ultimateParentOfV] = ultimateParentOfU;
            size[ultimateParentOfU] += size[ultimateParentOfV];
        }
    }
}

class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int dots = n + 1;
        int totalDots = dots * dots;
        DisjointSet ds = new DisjointSet(totalDots);

        // Union the outer boundary dots with the top-left corner cell that is 0
        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || i == dots - 1 || j == 0 || j == dots - 1) {
                    int cellNumber = i * dots + j;
                    ds.unionBySize(0, cellNumber);
                }
            }
        }

        int regionCount = 1;

        for (int i = 0; i < n; i++) {
            char[] ch = grid[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '/') {
                    int cellNumber1 = i * dots + (j + 1);
                    int cellNumber2 = (i + 1) * dots + j;

                    if (ds.findUltimateParent(cellNumber1) == ds.findUltimateParent(cellNumber2))
                        regionCount++;

                    ds.unionBySize(cellNumber1, cellNumber2);
                } else if (ch[j] == '\\') {
                    int cellNumber1 = i * dots + j;
                    int cellNumber2 = (i + 1) * dots + (j + 1);

                    if (ds.findUltimateParent(cellNumber1) == ds.findUltimateParent(cellNumber2))
                        regionCount++;

                    ds.unionBySize(cellNumber1, cellNumber2);
                }else{
                    continue;
                }
            }
        }

        return regionCount;
    }
}
