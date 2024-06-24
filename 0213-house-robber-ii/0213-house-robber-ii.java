class Solution {
    public int rob(int[] nums) {
        //if we have only one house 
        if(nums.length==1) return nums[0];
        //in this follow up we know 1st element of nums and last element of nums are neighbors so there are two cases -> we apply same logic of maximum Non adjacent sum of a subsequence then return the max one

        //case 1: leave the first element (1 to n-1)
        //case 2: leave the last element ie (0 to n-2)
        int[] case1=new int[nums.length-1];
        int[] case2=new int[nums.length-1];

        for(int i=1; i<nums.length; i++){
            case1[i-1]=nums[i];
        }
        for(int i=0; i<nums.length-1; i++){
            case2[i]=nums[i];
        }

        return Math.max(maximumNonAdjacentSum(case1), maximumNonAdjacentSum(case2));
    }
    public int maximumNonAdjacentSum(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		Arrays.fill(dp, -1);

		return helperDP(n - 1, nums, dp);
	}

	private int helperDP(int index, int[] nums, int[] dp) {
		if (index == 0) return nums[index]; //if we have reached index 0 then we did not pick element at index 1
		if (index < 0) return 0; //for negative index we return 0;

		if (dp[index] != -1) return dp[index];

		int pick = nums[index] + helperDP(index - 2, nums, dp); //if we pick element at current index we cannot pick the element at index-1

		int notPick = 0 + helperDP(index - 1, nums, dp); //if we didn't pick element at current index we can pick the element at index-1

		dp[index] = Math.max(pick, notPick);

		return dp[index];
	}
}