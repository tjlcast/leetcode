public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;

	boolean isV[][] ;
	int total = 0 ;
	int[][] directions = {{1,0}, {0, 1}, {0, -1}, {-1, 0}} ;
	char[][] board ;
	int rows ;
	int cols ;

    public int countBattleships(char[][] board) {
 		// pre 
 		rows = board.length ;
 		cols = board[0].length ;
 		this.board = board ;
 		isV = new boolean[rows][cols] ;

 		for(int i=0; i<rows; i++) {
 			for(int j=0; j<cols; j++) {
 				if (board[i][j] == 'X' && isV[i][j] == false) {
 					total++ ;
 					dfs(i, j) ;
 				}
 			}
 		}
 		return total ;
    }

    public void dfs(int x, int y) {
    	isV[x][y] = true ;

    	for(int k=0; k<directions.length; k++) {
    		int newX = x + directions[k][0] ;
    		int newY = y + directions[k][1] ;

    		if (newX<0 || newX>=rows || newY<0 || newY>=cols) continue ;
    		if (board[newX][newY] == 'X' && isV[newX][newY] == false) {
 					dfs(newX, newY) ;
 			}
    	}
    }
}
