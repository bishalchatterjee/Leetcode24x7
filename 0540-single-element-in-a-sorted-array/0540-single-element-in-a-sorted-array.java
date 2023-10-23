class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        
        //trim down the search space by eleminating base case at first - to avoid edge cases in actual binary search space 

        if(n==1) return nums[0];
        //first element is the single element
        if(nums[0]!=nums[1]) return nums[0];
        //last element is the single element
        if(nums[n-1]!=nums[n-2]) return nums[n-1];

        //since first and last elements have been already checked and search space is reduced set low and high accordingly
        int low=1;
        int high=nums.length-2;

        while(low<=high){
            int mid=low+(high-low)/2;

            // 0 1 2 3 4 5 6 7 8
            //[1,1,2,3,3,4,4,8,8]


            // 0 1 2 3  4  5  6 
            //[3,3,7,7,10,11,11]

            //search 
            if((nums[mid] != nums[mid-1]) && (nums[mid] != nums[mid+1])) return nums[mid];

            //elemenate - (even,odd) - left half, sicne signle element is on the right half
            if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2!=0 && nums[mid]==nums[mid-1])){
                low=mid+1;
            }else{
            //elemenate - (odd,even) - right half, since single elemenet is on the left half
                high=mid-1;
            }
        }
        return -1; //dummy statement & will never execute as there always exists a single element
    }
}