package Algorithms;

import java.util.Hashtable;

public class Climbing_Stairs_70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12 ;
		
		Solution_Climbing_Stairs_70 s = new Solution_Climbing_Stairs_70() ;
		int ans = s.climbStairs(n) ;
		
		System.out.println("ans: " + ans) ;
	}

}

class Solution_Climbing_Stairs_70 {
	private int ans_count ;
	private Hashtable<Integer, Integer> setpSet ;
	
    public int climbStairs(int n) {
//    	setpSet = new Hashtable<Integer, Integer>() ;
//        ans_count = 0 ;
//        
//        dfs(n);
//        
//        return ans_count ;
    	
    	return dfs2(n) ;
    }
    
    public void dfs(int rest) {
    	if(rest < 0) {
    		return ;
    	}
    	
    	if(rest == 0) {
    		this.ans_count++ ;
    	}
    	
    	
    	int[] step = {1, 2} ;
    	for(int i=0; i<step.length; i++) {
    		dfs(rest - step[i]) ;
    	}
    }
    
    public int dfs2(int rest) {
    	int[] step = new int[rest+1] ;
    	
    	step[0] = 1;
    	step[1] = 1 ;
    	if(rest <= 0) return 0 ;
    	if(rest < 1) return 1 ;
    	
    	for(int i=2; i<step.length; i++) {
    		step[i] = step[i-1] + step[i-2] ;
    	}
    	
    	return step[step.length-1] ;
    }
}