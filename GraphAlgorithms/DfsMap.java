import java.util.*;

public class DfsMap{
    public static void dfs(Map<String, List<String>> graph, String node, Set<String> visited){
        if (visited.contains(node)){
            return;
        }

        visited.add(node);
        System.out.println(node);

        for (String neighbor : graph.getOrDefault(node, Collections.emptyList())){
            dfs(graph, neighbor, visited);
        }
    }
    public static void main(String[] args){
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D", "E"));
        graph.put("C", Arrays.asList("F"));
        graph.put("D", Collections.emptyList());
        graph.put("E", Collections.emptyList());
        graph.put("F", Collections.emptyList());

        Set<String> visited = new HashSet<>();
        System.out.println("DFS Traversal");
        dfs(graph, "A", visited);
    }
}