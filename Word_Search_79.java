package Algorithms;

public class Word_Search_79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'A','B','C','E'} ,
				{'S','F','C','S'} , 
				{'A','D','E','E'} ,
		} ;
		String word = "ABCCED" ;
		Solution_Word_Search_79 s = new Solution_Word_Search_79() ;
		boolean ans = s.exist(board, word) ;
		
		if(ans == true){
			System.out.println("Yes") ;
		} else {
			System.out.println("No") ;
		}
	}

}


class Solution_Word_Search_79 {
    
    int[][] is_visited ;
    
    public boolean exist(char[][] board, String word) {
        is_visited = new int[board.length][] ;
        boolean is_find = false ;
        for(int i=0; i<is_visited.length; i++) {
            is_visited[i] = new int[board[0].length] ;
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                initial() ;
                is_find = dfs(board, i, j, word, 0) ;
                if(is_find == true) return is_find ;
            }
        }
        
        return is_find ;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int pos) {
        //System.out.println("pos: " + pos) ;
        boolean is_find = false ;
        is_visited[i][j] = 1 ;
        if(board[i][j] != word.charAt(pos)) { 
            is_visited[i][j] = 0 ;
            return false;
        }
        
        if(pos == word.length()-1) {
            is_visited[i][j] = 0 ;
            System.out.println("Yes") ;
            return true;
        }
        
        //System.out.println("i: " + i + " j: " + j + " char: " + word.charAt(pos) + " pos: " + pos) ;
        
        if(i+1 < board.length && is_visited[i+1][j] == 0) {
            is_find = dfs(board, i+1, j, word, pos+1) ;
            if(is_find == true) return is_find ;
        }
        if(j+1 < board[0].length && is_visited[i][j+1] == 0) {
            is_find = dfs(board, i, j+1, word, pos+1) ;
            if(is_find == true) return is_find ;
        }
        if(i-1 >= 0 && is_visited[i-1][j] == 0) {
            is_find = dfs(board, i-1, j, word, pos+1) ;
            if(is_find == true) return is_find ;
        }
        if(j-1 >= 0 && is_visited[i][j-1] == 0) {
            is_find = dfs(board, i, j-1, word, pos+1) ;
            if(is_find == true) return is_find ;
        }
        
        is_visited[i][j] = 0 ;
        return is_find ;
    }
    
    private void initial() {
        int row = is_visited.length ;
        int col = is_visited[0].length ;
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                is_visited[i][j] = 0 ;
            }
        }
    }
}