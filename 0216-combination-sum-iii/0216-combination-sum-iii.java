class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates=new int[]{1,2,3,4,5,6,7,8,9};

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];

        backtrackAndUpdate(candidates, visited, res, tempList, 0, 0, k, n);
        return res;
    }

    private void backtrackAndUpdate(int[] candidates, boolean[] visited, List<List<Integer>> res, List<Integer> tempList, int index,int countElements,int k, int target) {
        // base condition
        if (target == 0 && countElements==k) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0 && !visited[i]) {
                tempList.add(candidates[i]);
                visited[i] = true;
                backtrackAndUpdate(candidates, visited, res, tempList, i + 1,countElements + 1, k, target - candidates[i]);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
