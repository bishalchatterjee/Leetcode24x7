class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int n:nums){
            pq.offer(n);
        }

        int[] res=new int[nums.length];

        for(int i=0;i<res.length;i++){
            res[i]=pq.poll();
        }

        return res;
    }
}