class Pair {
    int node;
    int time;
    double probability;

    Pair(int node, int time, double probability) {
        this.node = node;
        this.time = time;
        this.probability = probability;
    }
}
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> adjList = buildGraphAdjList(n, edges);
        
        double probability = 1.0;
        boolean[] visited = new boolean[n + 1];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 0, 1.0));

        visited[1] = true;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            int node = curr.node;
            int time = curr.time;
            double prob = curr.probability;

            if (time == t) {
                if (node == target) {
                    return prob;
                } else {
                    continue;
                }
            }

            int childrenCountForCurrNode = 0;
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    childrenCountForCurrNode++;
                }
            }

            if (childrenCountForCurrNode == 0) {
                if (node == target) {
                    return prob;
                } else {
                    continue;
                }
            }

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new Pair(neighbor, time + 1, prob / childrenCountForCurrNode));
                }
            }
        }

        return 0.0;
    }

    private List<List<Integer>> buildGraphAdjList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }

        return adjList;
    }
}