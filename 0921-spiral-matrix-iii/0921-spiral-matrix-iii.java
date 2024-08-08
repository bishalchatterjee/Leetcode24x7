class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Directions: right, down, left, up
        int[][] res = new int[rows * cols][2];

        int steps = 0;
        int currDirection = 0;
        
        res[0] = new int[]{rStart, cStart};
        
        int count = 1;
        
        while (count < rows * cols) {
            if (currDirection == 0 || currDirection == 2) steps++;
            
            for (int i = 0; i < steps; i++) {
                rStart += dir[currDirection][0];
                cStart += dir[currDirection][1];
                
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    res[count] = new int[]{rStart, cStart};
                    count++;
                }
                
                if (count == rows * cols) return res;
            }
            
            currDirection = (currDirection + 1) % 4; // Change direction
        }
        
        return res;
    }
}
