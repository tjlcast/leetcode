package Algorithms;


public class Median_of_Two_Sorted_Arrays_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums1 = {1, 2, 3, 4} ;
//		int[] nums2 = {2, 3, 4, 5, 6, 7, 8} ;
		
//		int[] nums1 = {0, 3} ;
//		int[] nums2 = {1} ;
		
		int[] nums1 = {5,6,9,10} ;
		int[] nums2 = {1,2,3,4,7,8} ;
		//1 2 2 3 3 4 4 5 6 7 8
		
		double ans = Solution_Median_of_Two_Sorted_Arrays_4.findMedianSortedArrays(nums1, nums2) ;
		System.out.println("ans: " + ans) ;
	}

}


class Solution_Median_of_Two_Sorted_Arrays_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if((nums1.length + nums2.length)%2 == 0) {
    	   System.out.println("even") ;
    	   int data1 = findK(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1,(nums1.length + nums2.length)/2 ) ;
    	   int data2 = findK(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1,(nums1.length + nums2.length)/2+1) ;
    	   
    	   return (data1 + data2) / 2 ;
       } else {
    	   System.out.println("odd") ;
    	   int data1 = findK(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, (nums1.length + nums2.length)/2+1) ;
    	   
    	   return data1 ;
       }
    }
    
    public static int findK(int[] nums1, int b1, int e1, int[] nums2, int b2, int e2, int K) {
 
    	int len1 = e1 - b1 + 1 ;
    	int len2 = e2 - b2 + 1 ;
    	
    	if(len1 > len2) {
    		return findK(nums2, b2, e2, nums1, b1, e1, K) ;
    	}
    	System.out.println("b1: "+b1+" e1: "+e1+" b2: "+b2+" e2: "+e2+" K:" + K) ;
    	if(len1 == 0) {
    		return nums2[b2 + K - 1] ;
    	}
    	
    	if(K == 1) {
    		return Math.min(nums1[b1], nums2[b2]) ;
    	}
    	
    	int g1 = Math.min(e1, b1+K/2-1) ;
    	int g2 = b2+(g1-b1) ;
    	
    	System.out.println("g1: "+g1+"g2: "+g2) ;
    	
    	if(nums1[g1] == nums2[g2]) {
    		return nums1[g1] ;
    	} else if(nums1[g1] < nums2[g2]) {
    		return findK(nums1, g1+1, e1, nums2, b2, e2, K-(g1+1-b1))  ;
    	} else {
    		return findK(nums1, b1, e1, nums2, g2+1, e2, K-(g2+1-b2)) ;
    	}
    }
}


