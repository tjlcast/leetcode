public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public int thirdMax(int[] nums) {
        return work(nums) ;
    }
    
    public int work(int[] nums) {
        TreeSet<Integer> queue = new TreeSet<Integer>() ;
        
        for(int i=0; i<nums.length; i++) {
            int curNum = nums[i] ;
            if (queue.contains(curNum)) continue ;
            
            int tempNum = (queue.size() == 3)?(queue.pollFirst()):(Integer.MIN_VALUE) ;
        
            queue.add(((curNum > tempNum)?(curNum):(tempNum))) ;
        }
        
       
        if (queue.size() != 3) {
            return (int)queue.last() ;
        }
        return (int)queue.first() ;
    }
}
