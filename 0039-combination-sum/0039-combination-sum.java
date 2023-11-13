public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>(); 

        if (candidates.length == 1 && candidates[0] > target) return res;
        backtrackAndUpdate(candidates, res, tempList, 0, target); 
        return res;
    }

    private void backtrackAndUpdate(int[] candidates, List<List<Integer>> res, List<Integer> tempList, int index, int target) {
        // base condition
        if (target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                tempList.add(candidates[i]);
                backtrackAndUpdate(candidates, res, tempList, i, target - candidates[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
