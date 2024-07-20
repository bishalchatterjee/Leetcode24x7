class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] resMatrix = new int[rowSum.length][colSum.length];

        int currRow = 0;
        int currCol = 0; 

        while(currRow < rowSum.length && currCol < colSum.length){
            // Assigning the minimum value curRowSum and currColSum
            int value = Math.min(rowSum[currRow], colSum[currCol]);
            resMatrix[currRow][currCol] = value;
                
            rowSum[currRow] -= value; //Updating the value
            colSum[currCol] -= value;
            
            if(rowSum[currRow] == 0) 
                currRow++;
            else 
                currCol++;
        }
        return resMatrix;
    }
}

/*
Approach : Brute 

T.C - O(m * n)
S.C - O(1)

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

*/