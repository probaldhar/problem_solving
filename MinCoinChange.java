package projects;

//Find minimum number of coins
import java.util.*;

class MinCoinChange {

	public static int coinChange(int[] coins, int sum) {
	
	    // Make a matrix
	    int[][] matrix = new int[coins.length + 1][sum + 1];
	
	    for( int i = 0; i < matrix.length; i++ ) {
	        for( int j = 0; j < matrix[0].length; j++ ) {
	
	            // for each columns first value is INF
	            if (i == 0) {
	                matrix[i][j] = Integer.MAX_VALUE;
	                continue;
	            }
	
	            // for each rows first value is ZERO
	            if (j == 0) {
	                matrix[i][j] = 0;
	                continue;
	            }
	
	            // check the value of the previous row in the same column 
	            // and compare it with the (j - coins[i-1]) value
	            if (j - coins[i-1] >= 0) {
	                matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-coins[i-1]] + 1);
	            } else {
	                matrix[i][j] = matrix[i-1][j];
	            }
	        }
	    }
	
	    // for( int i = 0; i < matrix.length; i++ ) {
	    //     for( int j = 0; j < matrix[0].length; j++ ) {
	    //         System.out.print(matrix[i][j] + " ");
	    //     }
	    //     System.out.println();
	//    }
	
	    int row = coins.length, col = sum;
	    List<Integer> list = new ArrayList<>();
	    while(matrix[row][col] != 0) {
	        if (matrix[row][col] == matrix[row-1][col]) {
	            row = row -1;
	            continue;
	        } else {
	            list.add(coins[row-1]);
	            col = col - coins[row-1];
	        }
	    }
	    System.out.println(list);
	
	    return matrix[coins.length][sum];
	
	}
	
	public static void main(String args[]) {
	
	    int[] coins = {1,4,7,9};
	    int sum = 11;
	    
	    int getNumCoins = coinChange(coins, sum);
	
	    System.out.println(getNumCoins);
		
	}
}
