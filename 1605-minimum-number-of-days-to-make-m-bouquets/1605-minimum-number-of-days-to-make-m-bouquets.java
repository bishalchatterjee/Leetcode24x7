class Solution {
    public boolean possibleFunc(int [] arr, int mid, int m, int k){
        int count = 0;
        int noOfBouquets = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= mid){
                count++;
            }else{
                noOfBouquets += (count / k);
                count = 0;  
            }
        }
        noOfBouquets += count/k;
        if(noOfBouquets >= m){
            return true;
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long)m * (long)k;
        if(val > bloomDay.length){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<low){
                low = bloomDay[i];
            }
            if(bloomDay[i] > high){
                high = bloomDay[i];
            }
        }
        int ans = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(possibleFunc(bloomDay, mid, m, k) == true){
                ans = mid;
                high = mid - 1;

            }else {
                low = mid + 1;
            }
        }
    return ans;
    }
}