class Solution {
    public int shipWithinDays(int[] weights, int days) {
          int sum=0;
          for(int e:weights){
                sum+=e;
           }
          if(days==1) return sum;
          
          int low=Arrays.stream(weights).max().getAsInt();
          int high=sum;

          return binarySearchOnAnswers(weights,low,high,days);
    }
    //binarySearch
    private int binarySearchOnAnswers(int[] weights, int low, int high, int days){
        int res=Integer.MAX_VALUE;

        while(low<=high){
            int mid=low+(high-low)/2;

            int curr=getDaysRequiredForCurrentCapacity(weights,mid);

            if(curr<=days){
                res=Math.min(res,mid);
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
    //isPossible
    private int getDaysRequiredForCurrentCapacity(int[] weights,int capacity){
        int daysCount=1;

        int loadedWeight=0;

        for(int e:weights){
            
            if(loadedWeight + e > capacity){
                daysCount+=1;
                loadedWeight=e;
            }else{
                loadedWeight+=e;
            }
        }
        return daysCount;
    }
}