/*

Approach 1: BruteForce -> Generate all the subbarys

T.C - O(N^2)
S.C - O(1)

*/
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int maxP = nums[0];
        int minP = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = maxP;
                maxP = minP;
                minP = temp;
            }

            maxP = Math.max(nums[i], maxP * nums[i]);
            minP = Math.min(nums[i], minP * nums[i]);

            res = Math.max(res, maxP);
        }

        return res;
    }
}