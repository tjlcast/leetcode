public class NumArray {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "使用一个数组纪录，每一个位置表示当前位置之前数的和" ;
    
    private int[] count ;

    public NumArray(int[] nums) {
        count = new int[nums.length] ;
        int total = 0 ;
        
        for(int i=0; i<nums.length; i++) {
            total += nums[i] ;
            count[i] = total ;
        }
    }

    public int sumRange(int i, int j) {
          int A = count[j] ;
          int B = 0 ;
          
          if (i-1 >= 0) {
              B = count[i-1] ;
          }
          return A - B ;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
