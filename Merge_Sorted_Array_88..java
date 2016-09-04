public class Solution {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "success_V" ;
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        work(nums1, m, nums2, n) ;
        return ;
    }
    
    private void work(int[] nums1, int m, int[] nums2, int n) {
        
        int pos1 = m-1 ;
        int pos2 = n-1 ;
        int pos = nums1.length-1 ;
        
        while(pos1>=0 || pos2>=0) {
            int num1 = (pos1!=-1) ? (nums1[pos1]) : (-9999) ;
            int num2 = (pos2!=-1) ? (nums2[pos2]) : (-9999) ;
            
            int maxNum = -1 ;
            if (num1 > num2) {
                maxNum = num1 ;
                pos1-- ;
            } else {
                maxNum = num2 ;
                pos2-- ;
            }
            
            nums1[pos--] = maxNum ;
        }
        
        return ;
    }
}
