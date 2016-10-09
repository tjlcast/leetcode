public class NumMatrix {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "dp多维数组中存储了，该点的左上角区域的数据之和" ;
    
    private int[][] dp ;
    private boolean isZero ;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            isZero = true ;
            return ;
        }
        
        dp = new int[matrix.length][matrix[0].length] ;
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                int leftVal = getVal(dp, i, j-1) ;
                int rightVal = getVal(dp, i-1, j) ;
                int corVal = getVal(dp, i-1, j-1) ;
                dp[i][j] = leftVal + rightVal - corVal + matrix[i][j] ;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (isZero == true) return 0 ;
        
        int total = getVal(dp, row2, col2) ;
        int leftVal = getVal(dp, row2, col1-1) ;
        int rightVal = getVal(dp, row1-1, col2) ;
        int corVal = getVal(dp, row1-1, col1-1) ;
        total -= leftVal ;
        total -= rightVal ;
        total += corVal ;
        return total ;
    }
    
    private int getVal(int[][] matrix, int row, int col) {
        if (row<0 || col<0) return 0 ;
        
        return matrix[row][col] ;
    }
    
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
