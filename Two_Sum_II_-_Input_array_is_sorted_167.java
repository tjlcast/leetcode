public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return new Solution1().work(numbers, target) ;
    }
}

class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public int[] work(int[] numbers, int target) {
        int[] ans = null ;
        for (int i=0; i<numbers.length; i++) {
            System.out.println("curI:" + i + " num: " + numbers[i]) ;
            int number = numbers[i] ;
            int otherNumber = target - number ;
            
            int pos = find(i+1, numbers.length-1, numbers, otherNumber) ;
            if (pos != -1) {
                return new int[]{i+1, pos+1} ;
            }
        }
        return ans ;
    }
    
    private int find(int begin, int end, int[] numbers, int num) {
        int ans = -1 ;
        
        while(begin <= end) {
            int mid = (begin + end) >> 1;
            
            if (numbers[mid] == num) {
                return mid ;
            } else if(numbers[mid] > num) {
                end = mid-1 ;
            } else {
                begin = mid + 1 ;
            }
        }
        
        return ans ;
    }
}
