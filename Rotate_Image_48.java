package Algorithms;

public class Rotate_Image_48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1}} ;
		Solution_Rotate_Image_48 s = new Solution_Rotate_Image_48() ;
		s.rotate(matrix);
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j] + " ") ;
			}
			System.out.println("") ;
		}
	}

}

class Solution_Rotate_Image_48 {
    public void rotate(int[][] matrix) {
        //沿对角先
    	for(int i=0; i<matrix.length; i++) {
    		for(int j=i; j<matrix.length; j++) {
    			int temp = matrix[i][j] ;
    			matrix[i][j] = matrix[j][i] ;
    			matrix[j][i] = temp ;
    		}
    	}
    	
    	for(int i=0; i<matrix.length; i++) {
    		int l = 0 , r = matrix.length-1 ;
    		while(l < r) {
    			int temp = matrix[i][l] ;
    			matrix[i][l] = matrix[i][r] ;
    			matrix[i][r] = temp ;
    			l++ ;
    			r-- ;
    		}
    	}
    	//眼竖中心轴
    }
}