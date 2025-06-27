package Week9.Practice;

import java.util.*;

public class TaxiPay {
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

    public static int[] dijkstra(Map<Integer, List<Edge>> graph, int n, int start) {
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge current =  pq.poll();
            if (distance[current.node] < current.cost) continue;  // 이 코드는 그냥 외우자  ㅅㅂ

            List<Edge> neighbours = graph.get(current.node);
            if (neighbours == null) continue;

            for (Edge next : neighbours) {
                int nextCost = current.cost + next.cost;
                if (distance[next.node] > nextCost) {
                    distance[next.node] = nextCost;
                    pq.add(new Edge(next.node, nextCost));
                }
            }
        }
        return distance;
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] fare : fares) {
            int u  = fare[0], v = fare[1], w = fare[2];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new Edge(v, w));  //양방향일 경우
            graph.computeIfAbsent(v, x -> new ArrayList<>()).add(new Edge(u, w));  // 이렇게 u,v모두 넣어야 함
        }

        int[] s_dist = dijkstra(graph, n, s);
        int[] a_dist = dijkstra(graph, n, a);
        int[] b_dist = dijkstra(graph, n, b);

        int answer = Integer.MAX_VALUE;;
        for (int i = 1; i <= n; i++) {
            if (s_dist[i] != Integer.MAX_VALUE && a_dist[i] != Integer.MAX_VALUE && b_dist[i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, s_dist[i] +  a_dist[i] + b_dist[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] fares = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };
        System.out.println(solution(6, 4, 6, 2, fares));
    }
}
