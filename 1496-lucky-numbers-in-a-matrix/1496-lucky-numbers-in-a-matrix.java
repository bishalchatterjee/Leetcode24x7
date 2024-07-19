class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        for(int row = 0; row < matrix.length; row++){
            int minEle = Integer.MAX_VALUE;
            int minCol = -1;
            for(int col = 0; col < matrix[0].length; col++){
                if(matrix[row][col] < minEle){
                    minEle = matrix[row][col];
                    minCol = col;
                }
            }
            if(isMaxInCol(matrix, minCol, minEle)){
                res.add(minEle);
            }
        }

        return res;
    }

    private boolean isMaxInCol(int[][] matrix, int col, int potentialEle){
        for(int row = 0; row < matrix.length; row++){
            if(matrix[row][col] > potentialEle) return false;
        }
        return true;
    }
}
