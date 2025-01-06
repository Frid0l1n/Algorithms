import java.util.*;

public class Dijkstra{
    //constructor:
    static class Edge{
        int node, weight;

        Edge(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int start){
        int n = graph.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currNode = curr.node;
            int currDist = curr.weight;

            if (currDist > distances[currNode]) continue;

            for (Edge edge : graph.get(currNode)){
                int nextNode = edge.node;
                int nextDist = edge.weight;
                int newDist = currDist + nextDist;

                if (distances[nextNode] > newDist){
                    distances[nextNode] = newDist;
                    pq.add(new Edge(nextNode, newDist));
                }
            }
        }
        return distances;
    }

    static void addEdge(List<List<Edge>> graph, int s, int t, int w){
        graph.get(s).add(new Edge(t, w));
        graph.get(t).add(new Edge(s, w));
    }

    public static void main(String[] args){
        int nodes = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 2, 4);
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 1, 3, 5);
        addEdge(graph, 2, 3, 8);
        addEdge(graph, 2, 4, 10);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 3, 5, 6);
        addEdge(graph, 4, 5, 3);

        int startNode = 0;

        int[] distance = dijkstra(graph, startNode);
        System.out.println(Arrays.toString(distance));
    }
}