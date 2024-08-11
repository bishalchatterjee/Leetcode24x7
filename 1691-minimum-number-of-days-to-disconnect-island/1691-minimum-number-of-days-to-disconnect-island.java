class Solution {
    public int minDays(int[][] grid) {
        // If the grid initially has more than 1 island,ie islands are already disconnected then return 0
        if(countNumberOfIslands(grid) != 1) {
            return 0;
        }

        /*

        Possibility 1: Remove 0 island cells
        Possibility 2: Remove 1 island cells
        Possibility 3: Remove 2 island cells

        */

        // Try removing each land cell to see if it disconnects the island
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0; // Temporarily remove the land
                    if(countNumberOfIslands(grid) != 1) {
                        return 1; // Possibility 2, If removing this cell disconnects the island, return 1
                    }
                    grid[i][j] = 1; // Restore the land
                }
            }
        }

        // If no single removal disconnects the island, it takes 2 days
        return 2; // Possibility 3, by elimination of other possibilities
    }

    private int countNumberOfIslands(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]) {
                    helperDFS(i, j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

     private void helperDFS(int row, int col, int[][] grid, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) return;

        visited[row][col] = true;

        helperDFS(row + 1, col, grid, visited);
        helperDFS(row - 1, col, grid, visited);
        helperDFS(row, col + 1, grid, visited);
        helperDFS(row, col - 1, grid, visited);
    }
}
