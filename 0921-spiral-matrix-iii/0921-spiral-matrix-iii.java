class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int steps = 0;
        int currDirection = 0;
        
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Directions: right, down, left, up
        int[][] res = new int[rows * cols][2];
        
        res[0] = new int[]{rStart, cStart};

        int index = 1;

        while (index < rows * cols) {
            if (currDirection == 0 || currDirection == 2) steps++;
            
            for (int i = 0; i < steps; i++) {
                rStart += dir[currDirection][0];
                cStart += dir[currDirection][1];
                
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    res[index] = new int[]{rStart, cStart};
                    index++;
                }
                
                if (index == rows * cols) return res;
            }
            
            currDirection = (currDirection + 1) % 4; // Change direction
        }
        
        return res;
    }
}
