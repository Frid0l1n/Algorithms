import java.util.*;

public class Bfs{
    static void BFS(List<List<Integer>> adj, int s){
        boolean[] visited = new boolean[adj.size()];
        visited[s] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.println(curr);
            
            for(int i : adj.get(curr)){
                if (!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
    
    static void addEdge(List<List<Integer>> adj, int s, int t){
        adj.get(s).add(t);
        adj.get(t).add(s);
    }
    
    public static void main(String[] args){
        int edges[][] = {
            {1, 2}, {2, 4}, {1, 3}, {4, 5}
        };

        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        List<List<Integer>> adj = new ArrayList<>();


        for (int i = 0; i <= maxNode; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges){
            addEdge(adj, e[0], e[1]);
        }

        BFS(adj, 1);
    }
}