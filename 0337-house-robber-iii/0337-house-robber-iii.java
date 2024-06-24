/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        Set<TreeNode> dp=new HashSet<>();
        return helperDP(root, dp);
    }
    private int helperDP(TreeNode root, Set<TreeNode> dp){
        if(root==null) return 0;
        
        int pick=0;
        int left=0;
        int right=0;
        
        if(dp.contains(root)) return root.val;
        
        
        if(root.left!=null){
            left=helperDP(root.left.left, dp) + helperDP(root.left.right, dp);
        }
        
        if(root.right!=null){
            right=helperDP(root.right.left, dp) + helperDP(root.right.right, dp);
        }
        
        pick=root.val + left + right;
        
        int notPick=helperDP(root.left, dp) + helperDP(root.right, dp);
        
        
        root.val=Math.max(pick, notPick);
        dp.add(root);
        
        return root.val;
        
    }
}