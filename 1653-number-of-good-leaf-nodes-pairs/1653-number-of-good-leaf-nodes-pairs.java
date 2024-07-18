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
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;

        // Initialize the adjacency list and leaves list
        Map<TreeNode, List<TreeNode>> adjList = new HashMap<>();
        List<TreeNode> leaves = new ArrayList<>();

        storeLeaves(root, null, adjList, leaves);

        int ans = 0;

        for (TreeNode leaf : leaves) {
            ans += bfs(leaf, distance, adjList, leaves);
        }

        // Each pair is counted twice, so divide by 2
        return ans / 2;
    }

    private void storeLeaves(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> adjList, List<TreeNode> leaves) {
        if (node == null) return;

        // If the node is a leaf, add it to the leaves list
        if (node.left == null && node.right == null) {
            leaves.add(node);
        }

        // Add the node and its parent to the adjacency list
        adjList.putIfAbsent(node, new ArrayList<>());
        if (parent != null) {
            adjList.get(node).add(parent);
            adjList.get(parent).add(node);
        }

        // Recursively process the left and right children
        storeLeaves(node.left, node, adjList, leaves);
        storeLeaves(node.right, node, adjList, leaves);
    }

    private int bfs(TreeNode start, int distance, Map<TreeNode, List<TreeNode>> adjList, List<TreeNode> leaves) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(start);
        int dist = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (visited.getOrDefault(node, false)) continue;
                if (node != start && node.left == null && node.right == null) {
                    count++;
                }
                visited.put(node, true);
                for (TreeNode neighbor : adjList.get(node)) {
                    queue.offer(neighbor);
                }
            }
            dist++;
            if (dist > distance) break;
        }
        
        return count;
    }
}
