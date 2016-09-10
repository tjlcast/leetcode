public class Solution {
    public boolean canJump(int[] nums) {
        return new Solution3().work(nums) ;
    }
}

class Solution1 {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "wrong_ans_V" ;
    
    public boolean work(int[] nums) {
        return jump(nums, 0) ;
    }
    
    private boolean jump(int[] nums, int pos) {
        if (pos >= nums.length) {return false ;}
        if (pos == nums.length-1) {return true ;}
        
        int steps = nums[pos] ;
        int newPos = pos + steps ;
        if (newPos == pos) return false ;
        return jump(nums, newPos) ;
    }
}

class Solution2 {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "time_out_V" ;
    
    public boolean work(int[] nums) {
        return judgeJump(nums) ;
    }
    
    private boolean judgeJump(int[] nums) {
        boolean[] can = new boolean[nums.length] ;
        if (nums.length == 1) return true ;
        
        can[nums.length-1] = true ;
        for(int i=nums.length-2; i>=0; i--) {
            int maxPos = i + nums[i] ;
            if (maxPos>=nums.length) {
                can[i] = true ;
                continue ;
            }
            for(int k = i; k<=maxPos; k++) {
                if (can[k] == true) {
                    can[i] = true ;
                    break ;
                }
            }
        }
        
        return can[0] ;
    }
}

class Solution3 {
    
    String __author__ = "tangjiangliang" ;
    String __V__ = "success_V" ;
    String __tip__ = "maxPos表示当前可以到达的最远位置（之前的点计算得到）" ;
    
    public boolean work(int[] nums) {
        return directJump(nums) ;
    }
    
    private boolean directJump(int[] nums) {
        int maxPos = 0 ;
        
        for (int i=0; i<nums.length; i++) {
            if (i > maxPos){ return false ;}
            int newMaxPos = i + nums[i] ;
            maxPos = (maxPos < newMaxPos) ? (newMaxPos) : (maxPos) ;
        }
        
        return true ;
    }
}
