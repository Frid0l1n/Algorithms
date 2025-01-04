import java.util.*;

public class BellmanFord{
    static class Edge {
        int src, dest, weight;
        //constructor:
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int[] bellmanFord(List<Edge> edges, int nodes, int start) throws Exception {
        int[] distances = new int[nodes];
        Arrays.fill(distances, Integer.MAX_VALUE / 2);
        distances[start] = 0;

        for(int i = 0; i < nodes - 1; i++){
            for (Edge edge : edges) {
                if (distances[edge.src] != Integer.MAX_VALUE / 2 &&
                distances[edge.src] + edge.weight < distances[edge.dest]) {
                    distances[edge.dest] = distances[edge.src] + edge.weight;
                }
            }
        }

        for (Edge edge : edges){
            if (distances[edge.src] != Integer.MAX_VALUE / 2 &&
            distances[edge.src] + edge.weight < distances[edge.dest]){
                throw new Exception("Graph conatins a negative weight cycle");
            }
        }

        return distances;
    }

    public static void main(String[] args){
        int nodes = 5;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        int startNode = 0;

        try{
            int[] distances = bellmanFord(edges, nodes, startNode);
            System.out.println(Arrays.toString(distances));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}