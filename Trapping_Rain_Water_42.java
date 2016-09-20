package Algorithms;

public class Trapping_Rain_Water_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1} ;
		Solution_Trapping_Rain_Water_42 s = new Solution_Trapping_Rain_Water_42(height) ;
		int ans = s.trap(height) ;
//		System.out.println("ans: " + ans) ;
	}

}

class Solution_Trapping_Rain_Water_42 {

	int[] toRightHeight;
	int[] toLeftHeight;

	public Solution_Trapping_Rain_Water_42(int[] height) {
		toLeftHeight = new int[height.length];
		toRightHeight = new int[height.length];
		for (int i = 0; i < height.length; i++) {
			toLeftHeight[i] = -1;
			toRightHeight[i] = -1;
		}
	}

	public int trap(int[] height) {
		int ans = 0;
		
		toRight(height) ;
//		for(int i=0; i<height.length; i++) {
//			System.out.print(toRightHeight[i] + " ") ;
//		}
//		System.out.println("") ;
		
		toLeft(height) ;
//		for(int i=height.length-1; i>=0; i--) {
//			System.out.print(toRightHeight[i] + " ") ;
//		}
//		System.out.println("") ;
		
		int[] minHeight = new int[height.length] ;
		for(int i=0; i<height.length; i++) {
			minHeight[i] = Math.min(toLeftHeight[i], toRightHeight[i]) ;
		}
		
		for(int i=0; i<height.length; i++) {
//			System.out.print(minHeight[i] + " ") ;
			ans += (minHeight[i] - height[i]) ;
		}
//		System.out.println("") ;
		
		return ans;
	}

	public void toRight(int[] height) {
    	int pos = 0 ;
    	while(pos < height.length) {
    		int curHeight = height[pos] ;
			while(pos < height.length && curHeight >= height[pos]) {
				toRightHeight[pos] = curHeight ;
				pos++ ;
			}
    	}
    	
    }

	public void toLeft(int[] height) {
		int pos = height.length-1 ;
    	while(pos >= 0) {
    		int curHeight = height[pos] ;
			while(pos >= 0 && curHeight >= height[pos]) {
				toLeftHeight[pos] = curHeight ;
				pos-- ;
			}
    	}
	}
}