public class Solution {
    public int maximalSquare(char[][] matrix) {
        return new Solution1().work(matrix) ;
    }
}

class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    int[][] dp ;
    
    public int work(char[][] matrix) {
        
        if (matrix.length == 0) {
            return 0 ;
        }
        
        int ans = 0 ;
        dp = new int[matrix.length][matrix[0].length] ;
        for(int i=0; i<matrix.length; i++) {
            dp[i][0] = (matrix[i][0]=='1') ? (1) : (0) ;
            ans = Math.max(ans, dp[i][0]) ;
        }
        for(int i=0; i<matrix[0].length; i++) {
            dp[0][i] = (matrix[0][i]=='1') ? (1) : (0) ;
            ans = Math.max(ans, dp[0][i]) ;
        }
        
        
        
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[i].length; j++) {
                char c = matrix[i][j] ;
                if (c == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1 ;
                    ans = Math.max(ans, dp[i][j]) ;
                }
            }
        }
        
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[i].length; j++) {
                System.out.print(dp[i][j]+" ") ;
            }
            System.out.println() ;
        }
        
        return ans * ans ;
    }
}
