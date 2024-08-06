class Pair {
    int destinationNode;
    int edgeWeight;

    Pair(int destinationNode, int edgeWeight){
        this.destinationNode = destinationNode;
        this.edgeWeight = edgeWeight;
    }
}
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<Pair>> adjList = buildGraph(edges, n);
int[] ans = new int[n];
        Arrays.fill(ans, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        pq.offer(new int[]{0, 0});  // {time, node}

        while (!pq.isEmpty()) {
            int[] timeNode = pq.poll();
            int time = timeNode[0];
            int u = timeNode[1];

            if (ans[u] == -1 || ans[u] > time) {
                ans[u] = time;
                for (Pair neighbor : adjList.get(u)) {
                    int v = neighbor.destinationNode;
                    int w = neighbor.edgeWeight;
                    if (time + w < disappear[v]) {
                        pq.offer(new int[]{time + w, v});
                    }
                }
            }
        }

        return ans;
    }

    private List<List<Pair>> buildGraph(int[][] edges, int n){
        List<List<Pair>> adjList = new ArrayList<>();
    
    
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }


        for(int[] edge : edges){
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            adjList.get(start).add(new Pair(end, weight));
            adjList.get(end).add(new Pair(start, weight));
        }

        return adjList;
    }
}