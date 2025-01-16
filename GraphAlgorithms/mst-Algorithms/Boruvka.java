import java.util.ArrayList;
import java.util.List;

// Utility class to represent an edge in the graph
class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

// Graph class that contains Boruvka's algorithm
class Graph {
    int V, E; // Number of vertices and edges
    List<Edge> edges;

    Graph(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
    }

    void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
        E = edges.size();
    }

    int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    void boruvkaMST() {
        int[] parent = new int[V];
        int[] rank = new int[V];
        Edge[] cheapest = new Edge[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int numComponents = V;
        int mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();

        while (numComponents > 1) {
            for (int i = 0; i < V; i++) {
                cheapest[i] = null;
            }

            for (Edge edge : edges) {
                int set1 = find(parent, edge.src);
                int set2 = find(parent, edge.dest);

                if (set1 != set2) {
                    if (cheapest[set1] == null || edge.weight < cheapest[set1].weight) {
                        cheapest[set1] = edge;
                    }
                    if (cheapest[set2] == null || edge.weight < cheapest[set2].weight) {
                        cheapest[set2] = edge;
                    }
                }
            }

            for (int i = 0; i < V; i++) {
                if (cheapest[i] != null) {
                    Edge edge = cheapest[i];
                    int set1 = find(parent, edge.src);
                    int set2 = find(parent, edge.dest);

                    if (set1 != set2) {
                        union(parent, rank, set1, set2);
                        mstEdges.add(edge);
                        mstWeight += edge.weight;
                        numComponents--;
                    }
                }
            }
        }

        System.out.println("Edges in MST:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
        System.out.println("Weight of MST: " + mstWeight);
    }
}

public class Boruvka {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        graph.boruvkaMST();
    }
}
