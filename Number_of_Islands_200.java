public class Solution {
    public int numIslands(char[][] grid) {
        return new Solution1().work(grid) ;
    }
}

class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    int[][] map ;
    int isLandNo = 0 ;
    
    public int work(char[][] grid) {
        if (grid.length == 0) {
            return 0 ;
        }
        
        map = new int[grid.length][grid[0].length] ;
        
        for(int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] == '1' && map[row][col] == 0) {
                    isLandNo++ ;
                    throughIsland(row, col, grid) ;
                }
            }
        }
        
        return isLandNo ;
    }
     
    private void throughIsland(int row, int col, char[][] grid) {
        //System.out.println("row: " + row + " col: " + col) ;
        
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}} ;
        map[row][col] = isLandNo ;
        for(int i=0; i<4; i++) {
            int newRow = row + directions[i][0] ;
            int newCol = col + directions[i][1] ;
            
            if (0<=newRow && newRow<map.length && 0<=newCol && newCol<map[0].length && grid[row][col] == '1' && map[newRow][newCol]==0) {
                throughIsland(newRow, newCol, grid) ;
            }
        }
    }
}
