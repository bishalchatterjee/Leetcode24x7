class Pair {
    int city;
    int timeElapsed;

    Pair(int city, int timeElapsed) {
        this.city = city;
        this.timeElapsed = timeElapsed;
    }
}

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adjList = buildGraph(edges, n);
       
        return helperModifiedDijkstra(adjList, n, time, change);
    }

    private int helperModifiedDijkstra(List<List<Integer>> adjList, int n, int time, int change) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.timeElapsed - b.timeElapsed));
        pq.add(new Pair(1, 0));

        Map<Integer, Integer> cache = new HashMap<>();
        
        Set<Integer> exhausted = new HashSet<>();

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currCity = curr.city;
            int currElapsedTime = curr.timeElapsed;

            // Base Termination: we have found our 2nd min time for city n
            if (currCity == n && currElapsedTime > cache.getOrDefault(currCity, Integer.MAX_VALUE)) {
                return currElapsedTime;
            }

            if (!cache.containsKey(currCity)) {
                // We visited this city for the first time, so elapsed time is min for this city
                cache.put(currCity, currElapsedTime);
            } else if (cache.get(currCity) == currElapsedTime || exhausted.contains(currCity)) {
                // Early termination if we are trying to visit the city 3rd time or more
                // or the elapsed time will not help in finding the solution
                continue;
            } else {
                // This means we are visiting the city with 2nd optimal time, we don't need to visit the city ever again
                exhausted.add(currCity);
            }

            // We visit the city at currElapsedTime, we need to check if on basis of change time,
            // whether this time falls in a cycle (green or red)
            // If odd cycle (red), we must wait for this cycle to end
            int factor = currElapsedTime / change;
            if (factor % 2 == 1) {
                currElapsedTime = (factor + 1) * change;
            }

            // Straightforward: visit the neighbors
            for (int neighbor : adjList.get(currCity)) {
                int visitTime = currElapsedTime + time;
                if (!exhausted.contains(neighbor)) {
                    pq.add(new Pair(neighbor, visitTime));
                }
            }
        }

        return -1;
    }

    private List<List<Integer>> buildGraph(int[][] edges, int n) {
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