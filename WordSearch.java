package projects;

import java.util.*;
/**
 * 
 * leetcode link: https://leetcode.com/problems/word-search/
 * 
 * @author probaldhar
 */

class WordSearch {
    
	/**
	 * A very very bad solution.
	 * 
	 * leetcode link: https://leetcode.com/problems/word-search-ii/
	 */
	public List<String> findWords(char[][] board, String[] words) {
        
        Set<String> uniqueResult = new HashSet<String>();
        
        for(String word: words) {
            if ( exist(board, word) ) {
                uniqueResult.add(word);
            }
        }
        
        return new ArrayList<String>(uniqueResult);
    }
	
	/**
	 * leetcode link: https://leetcode.com/problems/word-search/
	 */
    public boolean exist(char[][] board, String word) {
        // Visited array to keep track of the visited nodes
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[i].length; j++ ) {
                
                // check if the first char matches with the first char of the word
                // only one dfs call is sufficient as we're checking with backtracking
                if ( word.charAt(0) == board[i][j] && dfs(board, visited, word, i, j, 0) ) {
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        // we found the word in the board, yay!!
        if (index == word.length()) {
            return true;
        }
        
        if ( !isValid(board, visited, word, row, col, index) ) {
            return false;
        }
        
        // make the position visited
        visited[row][col] = true;
        
        // straight dfs for the next index
        if ( dfs(board, visited, word, row - 1, col, index+1) || 
             dfs(board, visited, word, row, col - 1, index+1) || 
             dfs(board, visited, word, row + 1, col, index+1) || 
             dfs(board, visited, word, row, col + 1, index+1) ) {
            return true;
        }
        
        // BACKTRACK !!
        // make the visited false to check again from another direction
        visited[row][col] = false;
        return false;
        
    }
    
    public boolean isValid(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        if ( visited[row][col]) {
            return false;
        }

        if(board[row][col] != word.charAt(index)) {
            return false;
        }

        return true;
    }
    
}



