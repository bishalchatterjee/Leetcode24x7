class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[][][] dp = new int[n][3][2]; // dp[i][j][0] for increasing, dp[i][j][1] for decreasing

        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }

        int totalTeams = 0;
        for (int i = 0; i < n; i++) {
            totalTeams += helperDP(i, 1, true, rating, dp) + helperDP(i, 1, false, rating, dp);
        }
        return totalTeams;
    }

    private int helperDP(int currIndex, int currTeamSize, boolean isIncreasing, int[] rating, int[][][] dp) {
        if (currTeamSize == 3) {
            return 1;
        }

        int direction = isIncreasing ? 0 : 1;
        if (dp[currIndex][currTeamSize][direction] != -1) {
            return dp[currIndex][currTeamSize][direction];
        }

        int count = 0;
        for (int nextIndex = currIndex + 1; nextIndex < rating.length; nextIndex++) {
            if ((isIncreasing && rating[currIndex] < rating[nextIndex]) || (!isIncreasing && rating[currIndex] > rating[nextIndex])) {
                count += helperDP(nextIndex, currTeamSize + 1, isIncreasing, rating, dp);
            }
        }

        dp[currIndex][currTeamSize][direction] = count;
        return count;
    }
}

/*

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[][][] dp = new int[n][n][4];  // We use 4 since team size ranges from 0 to 3

        // Initialize dp array with -1 indicating uncomputed states
        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }

        int totalTeams = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            totalTeams += helperDP(i, i, 1, rating, dp);
        }
        return totalTeams;
    }

    private int helperDP(int currIndex, int prevIndex, int currTeamSize, int[] rating, int[][][] dp) {
        if (currTeamSize == 3) {
            return 1;
        }

        if (dp[currIndex][prevIndex][currTeamSize] != -1) {
            return dp[currIndex][prevIndex][currTeamSize];
        }

        int count = 0;
        for (int nextIndex = currIndex + 1; nextIndex < rating.length; nextIndex++) {
            if (currTeamSize == 1 || (currTeamSize == 2 && ((rating[prevIndex] < rating[currIndex] && rating[currIndex] < rating[nextIndex]) || (rating[prevIndex] > rating[currIndex] && rating[currIndex] > rating[nextIndex])))) {
                count += helperDP(nextIndex, currIndex, currTeamSize + 1, rating, dp);
            }
        }

        dp[currIndex][prevIndex][currTeamSize] = count;
        return count;
    }
}
*/

/*
class Solution {
    public int numTeams(int[] rating) {
        int[] res = new int[1];

        for (int i = 0; i < rating.length - 2; i++) {
            helperDP(i, i, 1, rating, res);
        }
        return res[0];
    }

    private void helperDP(int currIndex, int prevIndex, int currTeamSize, int[] rating, int[] res) {
        if (currTeamSize == 3) {
            res[0] += 1;
            return;
        }

        for (int nextIndex = currIndex + 1; nextIndex < rating.length; nextIndex++) {
            if (currTeamSize == 1 || (currTeamSize == 2 && ((rating[prevIndex] < rating[currIndex] && rating[currIndex] < rating[nextIndex]) || (rating[prevIndex] > rating[currIndex] && rating[currIndex] > rating[nextIndex])))) {
                helperDP(nextIndex, currIndex, currTeamSize + 1, rating, res);
            }
        }
    }
}

*/
