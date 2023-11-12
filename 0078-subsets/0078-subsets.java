class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        backtrackHelper(nums,res,new ArrayList<>(),0);
        return res;
    }
    
    void backtrackHelper(int[] nums,List<List<Integer>> res,List<Integer> tempList,int startPoint){
        res.add(new ArrayList<>(tempList));
        
        for(int i=startPoint;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrackHelper(nums,res,tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}

/*
Less optimal code using recursion
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrackHelper(nums,res,new ArrayList<>(),0);
        return res;
    }
    
    void backtrackHelper(int[] nums,List<List<Integer>> res,List<Integer> tempList,int i){
        if(i==nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }

        //include the number
        tempList.add(nums[i]);
        backtrackHelper(nums,res,tempList,i+1);
        tempList.remove(tempList.size()-1);

        //not include the number
        backtrackHelper(nums,res,tempList,i+1);

    }
}
*/