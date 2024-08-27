class Pair {
    int node;
    double successProb;

    Pair(int node, double successProb) {
        this.node = node;
        this.successProb = successProb;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adjList = buildGraph(n, edges, succProb);
        return helperDijkstra(adjList, n, start_node, end_node);
    }

    private double helperDijkstra(List<List<Pair>> adjList, int n, int start_node, int end_node) {
        double[] probs = new double[n];  
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Double.compare(y.successProb, x.successProb));  
        pq.offer(new Pair(start_node, 1.0));
        probs[start_node] = 1.0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int parent = current.node;
            double prob = current.successProb;

            if (parent == end_node) {
                return prob;
            }

            for (Pair neighbor : adjList.get(parent)) {
                int child = neighbor.node;
                double edgeProb = neighbor.successProb;

                if (probs[child] < prob * edgeProb) {
                    probs[child] = prob * edgeProb;
                    pq.offer(new Pair(child, probs[child]));
                }
            }
        }

        return 0.0; 
    }

    private List<List<Pair>> buildGraph(int n, int[][] edges, double[] succProb) {
        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            double probability = succProb[i];

            adjList.get(start).add(new Pair(end, probability));
            adjList.get(end).add(new Pair(start, probability));
        }

        return adjList;
    }
}
