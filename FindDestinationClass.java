package projects;

import java.util.*;

class FindDestinationClass {
	
	static class ParentPath {
		public int x;
		public int y;

		public ParentPath(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * create a list, add row and col's value in the list
	 * add the list to the queue.
	 * 
	 * @param queue
	 * @param row
	 * @param col
	 */
    public static void add(Queue<List<Integer>> queue, int row, int col){
        List<Integer> list = new ArrayList<>();
        list.add(row);
        list.add(col);
        queue.add(list);
    }

    /**
     * Function to find the distance between the start node and the destination.
     * 
     * @param path
     * @return minimum distance to reach the destination
     */
	public static int findDistance(int[][] path) {
		
		// store the "node" of each node
		ParentPath parentPath[][] = new ParentPath[path.length][path[0].length];
		
		for (int i = 0; i < path.length; i++ ) {
        	for (int j = 0; j < path[i].length; j++) {
        		parentPath[i][j] = new ParentPath(-1,-1);
        	}
        }

		// Visited array to keep track of the visited nodes
        boolean[][] visited = new boolean[path.length][path[0].length];
        
        // what is dist? -> keeping track of the path 
        // from source to destination
        int[][] dist = new int[path.length][path[0].length];
        
        // queue of a list
        // list to store the value of row and col
        Queue<List<Integer>> queue = new java.util.LinkedList<>();
        
        // Add the starting node in the queue
        add(queue, 0, 0);

//        int[] nextRowMove = {-1, 1, 0, 0};
//        int[] nextColMove = {0, 0 , 1, -1};
        
        // knight's move in a board
        int[] nextRowMove = {-1, 1, -1, 1, 2, -2, 2, -2};
        int[] nextColMove = {-2, -2, 2, 2, 1, 1, -1, -1};
        
        ParentPath rowNode = new ParentPath(0, 0);
        parentPath[0][0] = rowNode;
        
        // check until queue is empty
        while(!queue.isEmpty()){
        	// pop last node from the queue
            List<Integer> position = queue.poll();
            
            // get the value of row and col
            int row = position.get(0);
            int col = position.get(1);

            // mark it visited
            visited[row][col] = true;

            // at first it will be 0, but afterwards it will increase the value with the path to the destination
            int currentDist = dist[row][col];
            
//            int ifDestination = checkNeighbours(path, visited, dist, nextRowMove, nextColMove, currentDist, row, col, queue);
            
//            if (ifDestination != -1) {
//            	return ifDestination;
//            }
            
            // check for adjacent nodes of the current node
            // left, right, top and bottom
            for(int i = 0; i < nextRowMove.length; i++) {

                int nextRow = row + nextRowMove[i];
                int nextCol = col + nextColMove[i];

                /**
                 *  check if the node is valid
                 *  valid means
                 *  1. value is within the range of row and col
                 *  2. not visited
                 *  3. value of it not 0
                 */ 
                if(isValid(visited, path, nextRow, nextCol)){
                	
                	// store the parentNode
                	ParentPath rowColNode = new ParentPath(row, col);
                    parentPath[nextRow][nextCol] = rowColNode;

                	// Increase the value with the next path to the destination
                    dist[nextRow][nextCol] = currentDist + 1;    

                    // if destination reached then increase the destination hop
                    if(isDestination(path, nextRow, nextCol)) {
                    	
                    	// print full path from destination to root
//                    	printFullPath(parentPath, nextRow, nextCol);
                    	
                        return currentDist + 1;
                    }

                    // If the node is not visited and within the matrix, add the node to the queue
                    add(queue, nextRow, nextCol);
                }

            }

        }

        return -1;
    }

	/**
	 * Check if the current node is the destination
	 * 
	 * @param path
	 * @param row
	 * @param col
	 * @return
	 */
    public static boolean isDestination(int[][] path, int row, int col) {
        return path[row][col] == 9;
    }

    /**
     * Check if the node is visited
     * 
     * @param visited
     * @param path
     * @param row
     * @param col
     * @return
     */
    public static boolean isValid(boolean[][] visited, int[][] path, int row, int col) {
        if(row < 0 || col < 0 || row >= visited.length || col >= visited[0].length) {
            return false;
        }

        if ( visited[row][col]) {
            return false;
        }

        if(path[row][col] == 0) {
            return false;
        }


        return true;
    }
    
//    public static int checkNeighbours(int[][] path, boolean[][] visited, int[][] dist, int[] nextRowMove, int[] nextColMove, int currentDist, int row, int col, Queue<Integer> queue){
//    	// check for adjacent nodes of the current node
//        // left, right, top and bottom
//        for(int i = 0; i < nextRowMove.length; i++) {
//
//            int nextRow = row + nextRowMove[i];
//            int nextCol = col + nextColMove[i];
//
//            /**
//             *  check if the node is valid
//             *  valid means
//             *  1. value is within the range of row and col
//             *  2. not visited
//             *  3. value of it not 0
//             */ 
//            if(isValid(visited, path, nextRow, nextCol)){
//
//            	// Increase the value with the next path to the destination
//                dist[nextRow][nextCol] = currentDist + 1;    
//
//                // if destination reached then increase the destination hop
//                if(isDestination(path, nextRow, nextCol)) {
//                	
//                	// print full path from destination to root
////                	printFullPath(parentPath, nextRow, nextCol);
//                	
//                    return currentDist + 1;
//                }
//
//                // If the node is not visited and within the matrix, add the node to the queue
//                add(queue, nextRow, nextCol);
//            }
//
//        }
//        
//        return -1;
//    }
    
    public static void printFullPath(ParentPath parentPath[][], int destRow, int destCol) {
    	System.out.println(destRow + ", " + destCol);
    	
    	while (parentPath[destRow][destCol].x != 0 || parentPath[destRow][destCol].y != 0) {
    		System.out.println(parentPath[destRow][destCol].x + ", " + parentPath[destRow][destCol].y);
    		destRow = parentPath[destRow][destCol].x;
    		destCol = parentPath[destRow][destCol].y;
    	}
    	System.out.println(parentPath[destRow][destCol].x + ", " + parentPath[destRow][destCol].y);
    }
    
    public static void main(String args[]) {
		int[][] path = {
                        {1,1,1,1,0,1},
                        {1,0,1,1,0,0},
                        {1,1,0,0,0,1},
                        {1,1,0,9,0,1},
                        {1,1,0,0,0,1},
                        {1,1,1,1,0,1},
        };

        int[][] path1 = {
                        {1,1,1,1,0,1},
                        {1,0,1,1,0,0},
                        {1,1,0,0,0,1},
                        {1,1,0,1,0,1},
                        {1,1,0,9,0,1},
                        {1,1,1,1,0,1},
        };

        int[][] path2 = {
                        {1,1,1,1,0,1},
                        {1,0,1,1,0,0},
                        {1,1,0,1,0,1},
                        {1,1,0,9,0,1},
                        {1,1,0,1,0,1},
                        {1,1,1,1,0,1},
        };

        int dist = findDistance(path1);
        System.out.println(dist);

	}
}
