package Algorithms;

public class Set_Matrix_Zeroes_73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = {
				{1, 2, 0}, 
				{0, 1, 1}, 
				{1, 1, 1}
		} ;
		
		Solution_Set_Matrix_Zeroes_73 s = new Solution_Set_Matrix_Zeroes_73() ;
		s.setZeroes(matrix);
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ") ;
			} System.out.println("") ;
		}
	}

}


class Solution_Set_Matrix_Zeroes_73 {
    public void setZeroes(int[][] matrix) {
    	int row = matrix.length ;
    	int col = matrix[0].length ;
        int[] flag = new int[row + col] ;
        
        for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		if(matrix[i][j] == 0) {
        			flag[i] = 1 ;
        			flag[row + j] = 1 ;
        		}
        	}
        }
        
        for(int k = 0 ; k<flag.length; k++) {
        	if(flag[k] == 1) {
        		if(k <row) {
        			for(int i=0; i<col; i++) {
        				matrix[k][i] = 0 ;
        			}
        		} else {
        			for(int i=0; i<row; i++) {
        				matrix[i][k-row] = 0 ;
        			}
        		}
        	}
        }
        
    }
}