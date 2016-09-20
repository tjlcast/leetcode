package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Spiral_Matrix_54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
//				{1, 2, 3} ,
//				{4, 5, 6}
		} ;
		
		Solution_Spiral_Matrix_54 s = new Solution_Spiral_Matrix_54() ;
		ArrayList<Integer> ans = (ArrayList<Integer>) s.spiralOrder(matrix) ;
		
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ") ;
		}System.out.println("") ;
	}

}


class Solution_Spiral_Matrix_54 {
	
	private ArrayList<Integer> ansList ;
	int[][] isVisited ;
	
    public List<Integer> spiralOrder(int[][] matrix) {
        ansList = new ArrayList<>() ;
        if(matrix.length == 0) return ansList ;
        isVisited = new int[matrix.length][matrix[0].length] ;
        
        //initial 
        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[i].length; j++) {
        		isVisited[i][j] = 0 ;
        	}
        }
        
        dfs(0, 0, matrix);
        
        return ansList ;
    }
    
    private void dfs(int i, int j, int[][] matrix) {
    	
    	//System.out.println(matrix[i][j] + " i: " + i + " j: " + j) ;
    	
    	isVisited[i][j] = 1 ;
    	int temp = matrix[i][j] ;
    	ansList.add(temp) ;
    	
    	int[][] directoin = {
    			{0, +1} ,
    			{+1, 0} ,
    			{0, -1} ,
    			{-1, 0}
    	} ;
    	for(int k=0; k<directoin.length; k++) {
    		;
    		int new_x = i + directoin[k][0] ;
    		int new_y = j + directoin[k][1] ;
    		//System.out.println("K: " +  k + " new-x: " + new_x + " new_y: " + new_y) ; 
    		if(new_x >= 0 && new_y>=0 && new_y < matrix[0].length && new_x<matrix.length) {
    			if(isVisited[new_x][new_y] == 0) {
    				dfs(new_x, new_y, matrix);
    			}
    		}
    	}
    }
    
    private void dfs2(int i, int j, int[][] matrix) {
    	while(true) {
    		
    	}
    }
}