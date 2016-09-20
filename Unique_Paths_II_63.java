package Algorithms;

public class Unique_Paths_II_63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = {
				{0, 1}
//				{0, 0}, 
//				{1, 0}, 
		} ;
		Solution_Unique_Paths_II_63 s = new Solution_Unique_Paths_II_63() ;
		int ans = s.uniquePathsWithObstacles(obstacleGrid) ;
		System.out.println("ans: " + ans) ;
	}

}

class Solution_Unique_Paths_II_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return ans(obstacleGrid) ;
    }
    
    int ans(int[][] obstacleGrid) {
    	//obstacleGrid must have a row
    	int ans = 0;
    	int row_len = obstacleGrid[0].length ;
    	int[] row = new int[row_len+1] ;
    	
    	row[0] = 0 ;
    	for(int i=1; i<=row_len; i++) {
    		if(obstacleGrid[0][i-1] == 0) {
    			row[i] = 1 ;
    		} else {
    			for(; i<=row_len; i++) {
    				row[i] = 0 ;
    			}
    		}
    	}
    
    	
    	for(int i=2; i<=obstacleGrid.length; i++) {
    		for(int j=1; j<=row_len; j++) {
    			row[j] = row[j] + row[j-1] ;
    			if(obstacleGrid[i-1][j-1] == 1) {
    				row[j] = 0 ;
    			}
    		}
    	}
    
    	
    	ans = row[row_len];
    	
    	return ans ;
    }
}