class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = generateTopologicalSort(rowConditions, k);
        List<Integer> colOrder = generateTopologicalSort(colConditions, k);

        // If the topological sort does not include all k elements, return an empty matrix
        if (rowOrder.size() < k || colOrder.size() < k) {
            return new int[0][0];
        }

        // Create a mapping from element to its column index in the final matrix
        Map<Integer, Integer> colPosition = new HashMap<>();
        for (int i = 0; i < k; i++) {
            colPosition.put(colOrder.get(i), i);
        }

        // Construct the matrix
        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            matrix[i][colPosition.get(rowOrder.get(i))] = rowOrder.get(i);
        }

        return matrix;
    }

    private List<Integer> generateTopologicalSort(int[][] conditions, int k) {
        int[] inDegree = new int[k];
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and compute in-degrees
        for (int[] condition : conditions) {
            int from = condition[0] - 1;
            int to = condition[1] - 1;
            graph.get(from).add(to);
            inDegree[to]++;
        }

        // Find all nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Perform topological sort
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current + 1);
            for (int neighbor : graph.get(current)) {
                if (--inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return order;
    }
}
