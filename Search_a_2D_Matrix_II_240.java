public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "从右上角开始, 比较target 和 matrix[i][j]的值. 如果小于target, 则该行不可能有此数,  所以i++; 如果大于target, 则该列不可能有此数, 所以j--. 遇到边界则表明该矩阵不含target." ;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0 ;
        int j = matrix[0].length-1 ;
        
        while (0<=i && i<matrix.length && 0<=j && j<matrix[0].length) {
            int curNum = matrix[i][j] ;
            
            if (target < curNum) {
                j -= 1 ;
            } else if (target > curNum) {
                i += 1 ;
            } else {
                return true ;
            }
        }
        
        return false ;
    }
}
