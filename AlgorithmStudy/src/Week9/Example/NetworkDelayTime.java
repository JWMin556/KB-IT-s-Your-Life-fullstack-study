package Week9.Example;

import java.util.*;

public class NetworkDelayTime {
    static class Edge implements Comparable<Edge>{
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static int dijkstra(Map<Integer, List<Edge>> graph, int start, int n) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.cost > dist[current.node]) {continue;}  // 얘가 없어도 동작은 똑같이 한다. 다만, 얘를 넣어야 더 성능이 좋아짐

            List<Edge> neighbours = graph.get(current.node);
            if  (neighbours == null) {continue;}

            for (Edge neighbour : neighbours) {
                int newCost = current.cost + neighbour.cost;
                if (newCost < dist[neighbour.node]) {
                    dist[neighbour.node] = newCost;
                    pq.add(new Edge(neighbour.node, newCost));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {return -1;}
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] time: times) {
            int u = time[0], v = time[1], w = time[2];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new Edge(v, w));
        }
        return dijkstra(graph, k, n);
    }

    public static void main(String[] args) {
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(times1, 4, 2)); // Output: 2

        int[][] times2 = {{1, 2, 1}};
        System.out.println(networkDelayTime(times2, 2, 1)); // Output: 1

        int[][] times3 = {{1, 2, 1}};
        System.out.println(networkDelayTime(times3, 2, 2)); // Output: -1
    }
}
