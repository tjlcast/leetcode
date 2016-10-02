public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "因为是求下一状态的情况并且当前状态用0和1表示，于是使用十位数表示下一个状态。" ;
    
    
    public void gameOfLife(int[][] board) {
        
        //二号为将来的状态，一号位为当前状态
        
        int rows = board.length ;
        if (rows==0) return ;
        int cols = board[0].length ;
        if (cols==0) return ;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int num = getRoundLiveNum(i, j, board) ;
                System.out.println("num: " + num) ;
                if (num<2 || num>3) {
                    // to be die 
                 } else if (num == 3){
                    // die to live
                    board[i][j] += 2 ;
                    // nextState = 1 ;
                 } else {
                     System.out.println(" do nothing keep curState") ;
                     int state = (board[i][j] & 1) ;
                     if (state == 1) board[i][j] += 2 ;
                 }
            }
        }
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                board[i][j] = (board[i][j] & 2)==2 ? 1 : 0 ;
            }
        }
    }
    
    private int getRoundLiveNum(int i, int j, int[][] board) {
        int total = 0 ;
        
        int rows = board.length ;
        int cols = board[0].length ;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}} ;
        
        for(int k=0; k<directions.length; k++) {
            int row = i + directions[k][0] ;
            int col = j + directions[k][1] ;
            
            if (0<=row && row<rows && 0<=col && col<cols) {
                // System.out.println("row: " + row + " col: " + col) ;
                if (((board[row][col]) & 1) == 1)
                    total += 1 ;
            }
        }
        return total ;
    }
}
