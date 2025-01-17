import java.util.*;

public class kruskal{
    static class Edge{
        int src, dst, weight;

        public Edge(int src, int dst, int weight){
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    static class subset{
        public subset(int parent, int rank){
            this.parent = parent;
            this.rank = rank;
        }
    }
    public static void main(String[] args){
        int V = 4;
        List<Edge> edges = new ArrayList<>(List.of(new Edge(0, 1, 10), new Edge(0, 2, 6),
                    new Edge(0, 3, 5), new Edge(1, 3, 15),
                    new Edge(2, 3, 4)));
        
        edges.sort(new Comparator<Edge>(){
            @Override public int compare(Edge o1, Edge o2){
                return o1.weight - o2.weight;
            }
        });

        kruskalMst(V, edges);
    }

    private static void kruskalMst(int V, List<Edge> edges){
        int j = 0;
        int noOfEdges = 0;

        Subset subset = new Subset[V];
        Edge result = new Edge[V];

        for (int i = 0; i < V; i++){
            subset[i] = new Subset(i, 0);
        }

        while (noOfEdges < V){
            
        }
    }
}