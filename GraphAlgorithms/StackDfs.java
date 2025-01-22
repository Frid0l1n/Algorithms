import java.util.*;

public class StackDfs{

    private static void DFS(List<List<Integer>> adj, int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        boolean[] visited = new boolean[adj.size()];

        while(stack.isEmpty() == false){
            int s = stack.peek();
            stack.pop();

            if (visited[s] == false){
                System.out.println(s);
                visited[s] = true;
            }

            Iterator<Integer> it = adj.get(s).iterator();

            while (it.hasNext()){
                int v = it.next();
                if (!visited[v]){
                    stack.push(v);
                }
            }
        }
    }

    private static void addEdge(List<List<Integer>> adj, int s, int t){
        adj.get(t).add(s);
        adj.get(s).add(t);
    }

    public static void main(String[] args){
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}};

        int V = 4;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges){
            addEdge(adj, e[0], e[1]);
        }

        int start = 1;

        DFS(adj, start);
    }
}