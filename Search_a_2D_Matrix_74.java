package Algorithms;

public class Search_a_2D_Matrix_74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1,   3,  5,  7} ,
				{10, 11, 16, 20} , 
				{23, 30, 34, 50} 
		} ;
		int target = 3 ;
		
		Solution_Search_a_2D_Matrix_74 s = new Solution_Search_a_2D_Matrix_74() ;
		boolean ans = s.searchMatrix(matrix, target) ;
		if(ans) {
			System.out.println("Yes") ;
		} else {
			System.out.println("No") ;
		}
	}

}

class Solution_Search_a_2D_Matrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return solution1(matrix, target) ;
    }
    
    public boolean solution1(int[][] matrix, int target) {
    	int row = matrix.length ;
    	int col = matrix[0].length ;
    	
    	int[] data = new int[row * col] ;
    	for(int i=0; i<row; i++) {
    		for(int j=0; j<col; j++) {
    			data[i*col + j] = matrix[i][j] ;
    		}
    	}
    	
    	for(int i=0; i<row; i++) {
    		for(int j=0; j<col; j++) {
    			System.out.print(data[i*col + j] + " ") ;
    		}
    		System.out.println("") ;
    	}
    	
    	int l = 0 ;
    	int r = data.length-1 ;
    	
    	while(l <= r) {
    		System.out.println("l: " + l + " r: " + r) ;
    		int mid = (l + r) / 2 ;
    		
    		if(data[mid] == target) {
    			return true ;
    		} else if(data[mid] < target){
    			l = mid + 1 ;
    		} else {
    			r = mid - 1 ;
    		}
    	}
    	
    	return false ;
    }
}