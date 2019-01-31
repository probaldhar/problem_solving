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
}
