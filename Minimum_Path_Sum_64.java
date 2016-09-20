package Algorithms;

public class Minimum_Path_Sum_64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {
			{1, 2, 3} ,
			{1, 2, 3}
		} ;
		
		
		Solution_Minimum_Path_Sum_64 s = new Solution_Minimum_Path_Sum_64() ;
		int ans = s.minPathSum(grid) ;
		
		System.out.println("ans: " + ans) ;
	}

}

class Solution_Minimum_Path_Sum_64 {
    public int minPathSum(int[][] grid) {
        int[] row = new int[grid[0].length + 1] ;
        
        //initial 
        row[0] = 99999 ;
        row[1] = grid[0][0] ;
        for(int i=2; i<row.length; i++) {
        	row[i] = row[i-1] + grid[0][i-1] ;
        }
       
        
        //work
        for(int i=1; i<grid.length; i++) {
        	for(int j=1; j<row.length; j++) {
        		row[j] = row[j-1] < row[j] ? (row[j-1] + grid[i][j-1]) : (row[j] + grid[i][j-1]) ;
        	}
        	
        	for(int k=0; k<row.length; k++) {
            	System.out.print(row[k] + " ") ;
            }System.out.println("") ;
        }
        
        return row[row.length-1] ;
    }
}

