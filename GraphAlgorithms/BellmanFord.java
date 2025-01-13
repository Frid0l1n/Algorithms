import java.util.*;

public class BellmanFord {
    // Bellman-Ford algorithm
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[src] = 0;

        // Relax all edges (V - 1) times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != Integer.MAX_VALUE / 2 && dist[u] + wt < dist[v]) {
                    // Update shortest distance to node v
                    if (i == V - 1){
                        return new int[]{-1};
                    }

                    dist[v] = dist[u] + wt;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;

        int[][] edges = {
            {1, 3, 2},
            {4, 3, -1},
            {2, 4, 1},
            {1, 2, 1},
            {0, 1, 5}
        };

        int src = 0;
        int[] ans = bellmanFord(V, edges, src);

        if (ans.length == 1 && ans[0] == -1) {
            System.out.println("Negative weight cycle detected.");
        } else {
            System.out.println("Shortest distances from source " + src + ":");
            System.out.println(Arrays.toString(ans));
        }
    }
}
