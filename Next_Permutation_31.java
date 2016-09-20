package Algorithms;

public class Next_Permutation_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//{6, 5, 4, 8, 7, 5, 1}
		int[] nums = {1 ,2  ,3} ;
//		Solution_Next_Permutation_31.sort(nums, 0, 4) ;
		Solution_Mine.nextPermutation(nums);
		for(int num: nums) {
			System.out.println("num: " + num) ;
		}
	}

}

//���ȿ϶��Ӻ��濪ʼ����1��5������û���á�
//
//7��5��1������Ҳû��Ч������˶�������8��7��5��1�ǵݼ��ġ�
//
//�����Ҫ�ҵ���һ�����У��ҵ�������λ���ǹؼ���
//
//��Ϊ������ſ���ʹ�������ø���
//
//�����ҵ���4���Զ��׼�4������5������8����7������1��
//
//��˾���Ҫ�ҳ���4������Щ����������С��ֵ�����������ߵ�����
//
//��ô�������оͳ��ˣ�6 5 5 8 7 4 1
//
//Ȼ�����һ���������8 7 4 1��һ��������

class Solution_Mine {
    public static void nextPermutation(int[] nums) {
    	for(int i=nums.length-2; i>=0; i--) {
    		int minPos = -1 ;
    		for(int j=i+1; j<nums.length; j++) {
    			if(nums[j] > nums[i]) {
    				if(minPos == -1) {
    					minPos = j ;
    				} else {
    					if(nums[j] < nums[minPos]) {
    						minPos = j ;
    					}
    				}
    			}
    		}
    		
    		if(minPos != -1) {
    			int temp = nums[i] ;
    			nums[i] = nums[minPos] ;
    			nums[minPos] = temp ;
    			sort(nums, i+1, nums.length-1) ;
    			
    			return  ;
    		}
    	}
    	
    	sort(nums, 0, nums.length-1) ;
    	
    }
    
    
    static void sort(int[]nums, int begin, int end) {
    	System.out.println("Enter begin: " + begin + " end: " + end);
    	for(int i=begin; i<end; i++) {
    		for(int j=i+1; j<=end; j++) {
    			if(nums[i] > nums[j]) {
    				int temp = nums[i] ;
    				nums[i] = nums[j] ;
    				nums[j] = temp ;
    			}
    		}
    	}
    }
}



