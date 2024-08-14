class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low)/2;
            int pairCount = getPairCount(nums, mid);

            if (pairCount < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int getPairCount(int[] nums, int maxDifference) {
        int pairCount = 0;
        int left = 0;
        int right = 1;

        while(right < nums.length){
            if(nums[right] - nums[left] <= maxDifference){
                pairCount += right - left;
                right++;
            }else{
                left++;
            }
        }
        return pairCount;
    }
}
