
public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "数字可能是多位，在识别数字的时候需要向前多扫描" ;
    
    
    public int calculate(String s) {
        s = s.replace(" ", "") ;
    	LinkedList<Integer> nums = new LinkedList<Integer>() ;
    	LinkedList<Character> ops = new LinkedList<Character>() ;

    	Integer i=0 ;
    	while(i < s.length()) {
    		char word = s.charAt(i) ;

    		if (isSuperOp(word)) {
    			int nextNum = 0 ;
            	int j = i+1;
            	while(j<s.length() && isNum(s.charAt(j))) {
            		nextNum = Integer.parseInt(s.charAt(j)+"") + nextNum*10 ;
            		j++ ;
            	}
            	i = j-1 ;
            	
    			nums.addLast(nextNum) ;
    			int b = nums.pollLast() ;
    			int a = nums.pollLast() ;
    			nums.addLast(count(a, b, word)) ;
    		} else if (isLowOp(word)) {
    			ops.addLast(word) ;
    		} else if (isNum(word)) {
    		    int nextNum = 0 ;
            	int j = i;
            	while(j<s.length() && isNum(s.charAt(j))) {
            		nextNum = Integer.parseInt(s.charAt(j)+"") + nextNum*10 ;
            		j++ ;
            	}
            	i = j-1 ;
    			nums.addLast(nextNum) ;
    		} else {
    		    
    		}

    		i++ ;
    	}

    	while(ops.size() != 0) {
    		char op = ops.pollFirst() ;
    		int a = nums.pollFirst() ;
    		int b = nums.pollFirst() ;
    		nums.addFirst(count(a, b, op)) ;
    	}

    	return nums.pollFirst() ;
    }

    private int getNext(Integer i, String s) {
    	int total = 0 ;
    	int j = i + 1 ;
    	while(j<s.length() && isNum(s.charAt(j))) {
    		total = Integer.parseInt(s.charAt(j)+"") + total*10 ;
    		j++ ;
    	}
    	i = j-1 ;
    	
    	return total ;
    }

   	private boolean isSuperOp(char c) {
   		if (c=='*' || c=='/') {
   			return true ;
   		}
   		return false ;
   	}

   	private boolean isLowOp(char c) {
   		if (c=='+' || c=='-') {
   			return true ;
   		}
   		return false ;
   	}

   	private boolean isNum(char c) {
   		if ('0'<=c && c<='9') {
   			return true ;
   		}
   		return false ;
   	}

   	private int count(int a, int b, char op) {
   		switch(op) {
   			case '*':
   				return a * b ;
   			case '/':
   				return a / b ;
   			case '+':
   				return a + b ;
   			case '-':
   				return a - b ;
   			default:
   				return -1 ;
   		}
   	}

}
