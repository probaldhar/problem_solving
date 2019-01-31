package projects;

import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Arrays;


class IslandCount {
	public static void main(String args[]) {
        int[][] M = {
                    {0, 0, 0, 0, 1, 0},
                    {1, 0, 1, 1, 1, 0},
                    {0, 0, 0, 1, 1, 0},
                    {1, 1, 0, 0, 1, 0},
                    {1, 0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0, 0},
                    {0, 0, 1, 0, 1, 1}
        };

        int row = M.length;
        int col = M[0].length;

        Boolean[][] visited = new Boolean[row][col];

        Arrays.stream(visited).forEach(v -> Arrays.fill(v, false));

        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {

                if(!isIsland(M, i , j)) {
                    continue;
                }

                if(visited[i][j]){
                    continue;
                }

                count +=  visitIsland(M, visited, i, j);
                
            }

           
        }
        System.out.println("Number of Island:: " + count);

	}

    public static int visitIsland(int[][] M, Boolean[][] visited, int row, int col) {
        
        if(row < 0 && col < 0) {
            return 0;
        }        

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));

        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, +1, -1};

        while(!queue.isEmpty()) {

            Node node = queue.poll();
            visited[node.row][node.col] = true;

            for (int i = 0; i < 4; i++) {

                int nextRow = node.row + moveX[i];
                int nextCol = node.col + moveY[i];

                if(isValid(M , nextRow, nextCol) && isIsland(M, nextRow, nextCol) && !visited[nextRow][nextCol]){
                    queue.add(new Node(nextRow, nextCol));
                    
                }
            }
 
        }


        return 1;
    }


    public  static boolean isValid(int[][] M, int row, int col) {
        return row >= 0 && col >= 0 && row < M.length && col < M[0].length;
    }

    public  static boolean isIsland(int[][] M, int row, int col) {
        return M[row][col] == 1; 
    }

}

class Node {
    int row;
    int col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

