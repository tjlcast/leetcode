package Algorithms;

public class Unique_Paths_62 {

	public static void main(String[] args) {
		int m = 23 ;
		int n = 12 ;
		// TODO Auto-generated method stub
		Solution_Unique_Paths_62 s = new Solution_Unique_Paths_62() ;
		int ans = s.uniquePaths(m, n) ;
		System.out.println("ans: " + ans) ;
	}

}


class Solution_Unique_Paths_62 {
    
    public int uniquePaths(int m, int n) {
        return ans(m, n) ;
    }
    
    private int ans(int m, int n) {
        int[] row = new int[n+1] ;
        row[0] = 0 ;
        for(int i=1; i<=n; i++) {
            row[i] = 1 ;
        }
        
        for(int i=2; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                row[j] = row[j] + row[j-1] ;
            }
        }
        
        return row[n] ;
    }
    
    
}