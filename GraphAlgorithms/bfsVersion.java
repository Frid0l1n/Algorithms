import java.util.*;

public class bfsVersion{
    public static int steps(int[][] field, int i1, int j1, int i2, int j2){
        //size
        int n = field.length;
        int m = field[0].length;
        
        //directions of movement
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // queue to perform dfs
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{i1, j1, 0});
        visited[i1][j1] = true;

        while (!queue.isEmpty()){
            int current[] = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            if (x == i2 && y == j2){
                return steps;
            }

            for (int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = x + dy[i];

                //check for index out of bounds errors
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && field[newX][newY] == 0 && !visited[newX][newY]){
                    queue.add(new int[]{newX, newY, steps+1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[][] field = {
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0}
        };

        System.out.println(steps(field, 0, 0, 3, 4));
    }
}