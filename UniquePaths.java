package projects;

class UniquePaths {
	// m x n matrix
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            	// this is the first column or the first row
            	// number of ways anyone can go from top-left to bottom-right
            	// for [1 x (any number)] matrix -> only one possible way
            	// similar for [(any number) x 1] matrix -> only one possible way
                if (i == 0 || j == 0) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
        }
        
        return matrix[m-1][n-1];
    }
    
    /**
     * 	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
		The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
		Now consider if some obstacles are added to the grids. How many unique paths would there be?
		An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        // check the first column for obstacle
        if ( obstacleGrid[0][0] == 1 ) {
            return 0;
        }
        
        obstacleGrid[0][0] = 1;
        
        // obstacle    = 1
        // empty space = 0
        
        // check the first column
        for ( int i = 1; i < row; i++ ) {
            if ( obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1 ) {
                obstacleGrid[i][0] = 1;
            } else {
                obstacleGrid[i][0] = 0;
            }
        }
        
        // check the first column
        for ( int i = 1; i < col; i++ ) {
            if ( obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1 ) {
                obstacleGrid[0][i] = 1;
            } else {
                obstacleGrid[0][i] = 0;
            }
        }
        
        for ( int i = 1; i < row; i++ ) {
            for ( int j = 1; j < col; j++ ) {
                // 0 means empty space, no obstacle
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        
        return obstacleGrid[row-1][col-1];
        
    }
    
}
