class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0.0;
        int currElapsedTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int prepTime = customer[1];

            currElapsedTime = Math.max(currElapsedTime, arrivalTime) + prepTime;

            int waitTime = currElapsedTime - arrivalTime;

            totalWaitingTime += waitTime;
        }

        return totalWaitingTime / customers.length;
    }
}