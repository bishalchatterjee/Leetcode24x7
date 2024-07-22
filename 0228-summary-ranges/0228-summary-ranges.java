class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        
        if (nums.length == 0) {
            return list;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            
            // Traverse while the next number is consecutive
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            
            if (start != nums[i]) {
                // If start is different from the current number, add the range
                list.add(start + "->" + nums[i]);
            } else {
                // If start is the same as the current number, add the single number
                list.add(String.valueOf(start));
            }
        }
        
        return list;
    }
}