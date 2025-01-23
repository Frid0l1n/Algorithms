import java.util.*;

public class Main {
    static class Edge{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static int countEdges(int n, int m, int[][] edges, int s, int t){
        List<Edge>[] grap = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            graph[edge[0]].add(new Edge(edge[1], edge[2]));
            graph[edge[1]].add(new Edge(edge[0], edge[2]));

            int[] distFromS = dijkstra(n, graph, s);
            int[] distFromT = dijkstra(n, graph, t);

            int minCost = distFrom[t];
        }

        int uselessEdges = 0;
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            boolean isUeseful = (distFrom[u] + w + distFrom[v] == minCost) || (distFrom[v] + w + distFromT[u] == minCost);
            if(!isUseful){
                uselessEdges++;
            }
        }
        return uselessEdges;
    }

    public static int[] dijkstra(int n, List<Edge>[] graph, int start){
        int[] dist = new dist[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] {start, 0});
        
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int node = current[0];
            int currentDist = current[1];

            if (currentDist > dist[node]) continue;
            
            for (Edge edge : graph[node]) {
                int neighbor = edge.to;
                int newDist = currentDist + edge.weight;
                
                if (newDist < dist[neighbor]){
                    dist[neighbor] = newDist;
                    pq.add(new int[]{neighbor, newDist});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args){
        int n = 6;
        int m = 9;
        int[][] edges = {
            {0, 1, 1}, {0, 2, 2}, {1, 2, 1}, {1, 3, 4},
            {2, 3, 1}, {2, 4, 4}, {3, 5, 2}, {4, 5, 5},
            {0, 5, 10}
        }
        
        int s = 1;
        int t = 5;
    }
}