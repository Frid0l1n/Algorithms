import java.util.*;

public class Dfs{
    static void DFSRec(List<List<Integer>> adj, boolean[] visited, int s){
        visited[s] = true;
        System.out.println(s);

        for (int i : adj.get(s)){
            if (!visited[i]){
                visited[i] = true;
                DFSRec(adj, visited, i);
            }
        }
    }

    static void DFS(List<List<Integer>> adj, int s){
        boolean[] visited = new boolean[adj.size()];
        DFSRec(adj, visited, s);
    }

    static void addEdge(List<List<Integer>> adj, int s, int t){
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void main(String[] args){
        int[][] edges = {
            {1,3}, {1,2}, {3, 2}
        };

        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= maxNode; i++){
            adj.add(new ArrayList<Integer>());
        }

        for (int[] e : edges){
            addEdge(adj, e[0], e[1]);
        }

        DFS(adj, 1);
    }
}