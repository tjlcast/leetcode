public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private Sting __tips__ = "lol...." ;
    
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums) ;
        return nums[nums.length - k] ;
    }
}
