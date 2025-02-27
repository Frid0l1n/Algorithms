import java.util.*;

class articulationPoints{
	static void dfs(List<List<Integer>> adj, int start, ArrayList<Integer> visited, int i, int curr){
		visited.set(curr, 1);
		for (int x : adj.get(curr)){
			if (x != i){
				if (visited.get(x) == 0){
					dfs(adj, start, visited, i, x);
				}
			}
		}
	}

	static ArrayList<Integer> articulationPoints(List<List<Integer>> adj, int numNodes){
		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 1; i <= numNodes; i++){
			int numComponents = 0;

			ArrayList<Integer> visited = new ArrayList<>();
			for (int k = 0; k <= numNodes; k++){  // Use <= to cover all node numbers
				visited.add(0);  // Unvisited state
			}
			for (int j = 1; j <= numNodes; j++){
				if (j != i && visited.get(j) == 0){
					numComponents++;
					dfs(adj, i, visited, i, j);
				}
			}

			if (numComponents > 1){
				res.add(i);
			}
		}
		return res;
	}



	static void addEdges(List<List<Integer>> adj, int s, int t){
		adj.get(s).add(t);
		adj.get(t).add(s);
	}

	public static void main(String args[]){
		System.out.println("Graph: ");
		//number of nodes
		int n = 12;
		//define edges
		int[][] edges = {
			{1, 2}, {2, 3}, {1, 9}, {2, 3}, {3, 9}, {3, 4}, {4, 5}, {5, 6}, {4, 8}, {6, 8}, {6, 7}, {7, 8}, {1, 10}, {10, 11}, {11, 12}, {12, 10}
		};

		List<List<Integer>> adj = new ArrayList<>();

		int numOfEdges = 0;
		for (int i = 0; i < edges.length; i++){
			numOfEdges++;
		}
		System.out.println(numOfEdges);

		for (int i = 0; i <= numOfEdges; i++){
			adj.add(new ArrayList<Integer>());
		}

		Set<Integer> unique = new HashSet<Integer>();
		for(int[] e : edges){
			addEdges(adj, e[0], e[1]);
			unique.add(e[0]);
			unique.add(e[1]);
		}

		int numNodes = unique.size();

		ArrayList<Integer> ans = articulationPoints(adj, numNodes);
		for (int i : ans){
			System.out.print(i + " ");
		}
	}
}
