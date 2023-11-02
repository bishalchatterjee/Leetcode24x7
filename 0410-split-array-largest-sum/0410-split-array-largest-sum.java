class Solution {
    public int splitArray(int[] nums, int k) {
         if(nums.length==k){
            int maxEle=Arrays.stream(nums).max().getAsInt();
            return maxEle;
        }

        return binarySearchWithAnswers(nums, k);
    }
    private static int binarySearchWithAnswers(int[] nums,int k){
        int maxEle=Arrays.stream(nums).max().getAsInt();
        int sumOfEle=Arrays.stream(nums).sum();

        int low=maxEle;
        int high=sumOfEle;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isPossible(nums, k, mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    private static boolean isPossible(int[] nums,int k, int mid){
        int currPainterCount=1;
        int timeTaken=0;
        
        for(int i=0;i<nums.length;i++){
            if(timeTaken+nums[i]<=mid){
                timeTaken+=nums[i];
            }else{
                currPainterCount++;
                timeTaken=nums[i];
            }
        }
        return currPainterCount<=k?true:false;
    }
}