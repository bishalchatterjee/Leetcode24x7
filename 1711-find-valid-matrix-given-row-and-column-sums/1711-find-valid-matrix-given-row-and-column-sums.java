class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] resMatrix = new int[rowSum.length][colSum.length];

        for (int row = 0; row < rowSum.length; row++) {
            for (int col = 0; col < colSum.length; col++) {
                // Assigning the minimum value curRowSum and currColSum
                int value = Math.min(rowSum[row], colSum[col]);
                resMatrix[row][col] = value;
                
                rowSum[row] -= value; //Updating the value
                colSum[col] -= value;
            }
        }

        return resMatrix;
    }
}