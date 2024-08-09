class Solution {
    public int numMagicSquaresInside(int[][] grid) {        
        int rows = grid.length;
        int cols = grid[0].length;

        if (rows < 3 || cols < 3) {
            return 0;
        }

        int res = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isValidMagicSquare(i, j, grid)) {
                    res++;
                }
            }
        }

        return res;
    }

    private boolean isValidMagicSquare(int startX, int startY, int[][] grid) {
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        boolean[] seenNumbers = new boolean[10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = grid[startX + i][startY + j];

                // Check if the value is between 1 and 9 and unique
                if (value < 1 || value > 9 || seenNumbers[value]) {
                    return false;
                }
                seenNumbers[value] = true;

                // Calculate row and column sums
                rowSum[i] += value;
                colSum[j] += value;
            }
        }

        // Check if all row sums and column sums are equal
        for (int i = 1; i < 3; i++) {
            if (rowSum[i] != rowSum[i - 1] || colSum[i] != colSum[i - 1] || rowSum[0] != colSum[0]) {
                return false;
            }
        }

        // Check if diagonal sums are equal to row/column sums
        int diagonal1 = grid[startX][startY] + grid[startX + 1][startY + 1] + grid[startX + 2][startY + 2];
        int diagonal2 = grid[startX][startY + 2] + grid[startX + 1][startY + 1] + grid[startX + 2][startY];

        if (diagonal1 != diagonal2 || diagonal1 != rowSum[0]) {
            return false;
        }

        return true;
    }
}
