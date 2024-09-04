class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        Set<String> obstacleSet = new HashSet<>();

        int x = 0;
        int y = 0;
        int currDir = 0;
        int res = 0;
        
        for(int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + " " + obstacle[1]);
        }
        
        for(int i=0; i<commands.length; i++) {
            if(commands[i]==-1) {
               currDir = (currDir + 1) % 4;
            }else if(commands[i]==-2) {
                currDir = (currDir + 3) % 4;
            }else {
                while(commands[i]-- > 0 && !obstacleSet.contains((x + dir[currDir][0])+ " " +(y + dir[currDir][1]))) {
                    x += dir[currDir][0];
                    y += dir[currDir][1];
                }
            }
            res = Math.max(res, x*x + y*y);
        }
        return res;
    }
}