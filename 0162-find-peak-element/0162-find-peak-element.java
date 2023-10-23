class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;

        int potentialAns = Integer.MIN_VALUE;

        int n=nums.length;

        //corner cases
        if(nums[0]>nums[1]) potentialAns=Math.max(potentialAns,0);
        if(nums[n-1]>nums[n-2]) potentialAns=Math.max(potentialAns,n-1);

        int low=1;
        int high=n-2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            //search
            if ((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])) {
                potentialAns = Math.max(potentialAns,mid);
            }
            //eliminate
            if(nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return potentialAns;
    }
}