import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];

        Arrays.sort(candidates); // Sort candidates to handle duplicates

        backtrackAndUpdate(candidates, visited, res, tempList, 0, target);
        return res;
    }

    private void backtrackAndUpdate(int[] candidates, boolean[] visited, List<List<Integer>> res, List<Integer> tempList, int index, int target) {
        // base condition
        if (target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                // Skip duplicates to avoid duplicate combinations
                continue;
            }

            if (target - candidates[i] >= 0 && !visited[i]) {
                tempList.add(candidates[i]);
                visited[i] = true;
                backtrackAndUpdate(candidates, visited, res, tempList, i + 1, target - candidates[i]);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
