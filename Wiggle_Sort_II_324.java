public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "sort and depart" ;
    
    public void wiggleSort(int[] nums) {

        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(temp);
        int large = temp.length / 2 + (temp.length % 2 == 0 ? -1 : 0);
        int small = temp.length - 1;
        for (int i = 0, j = 1; i < temp.length; i+=2, j+=2) {
            if(j < temp.length) nums[j] = temp[small--];
            nums[i] = temp[large--];
        }
    }
}
