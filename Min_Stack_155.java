package Algorithms;

import java.util.ArrayList;

public class Min_Stack_155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack() ;
		ms.push(1);
		ms.push(2);
		ms.push(3) ;
		System.out.println("top: " + ms.top());
		System.out.println("min: " + ms.getMin());
		ms.pop();
		System.out.println("min: " + ms.getMin());
		ms.show();
	}

}

class MinStack {
	private ArrayList stack ;
	private ArrayList min_stack ;
	
    /** initialize your data structure here. */
    public MinStack() {
    	stack = new ArrayList<>() ;
    	min_stack = new ArrayList<>() ;
    }
    
    public void push(int x) {
        stack.add(new Integer(x)) ;
        
        if(min_stack.isEmpty()) {
        	min_stack.add(new Integer(x)) ;
        } else {
        	int top = (int) min_stack.get(min_stack.size()-1) ;
        	if(top >= x) {
        		min_stack.add(new Integer(x)) ;
        	}
        }
    }
    
    public void pop() {
    	if(stack.isEmpty()) return ;
        if(stack.get(stack.size()-1).equals(min_stack.get(min_stack.size()-1))) {
        	min_stack.remove(min_stack.size()-1) ;
        }
        stack.remove(stack.size()-1) ;
    }
    
    public int top() {
        return (int) stack.get(stack.size()-1) ;
    }
    
    public int getMin() {
        return (int) min_stack.get(min_stack.size()-1) ;
    }
    
    public void show() {
    	System.out.println("stack") ;
    	for(int i=0; i<stack.size(); i++) {
    		System.out.print(stack.get(i) + " ") ;
    	}
    	System.out.println("") ;
    	
    	System.out.println("min_stack") ;
    	for(int i=0; i<min_stack.size(); i++) {
    		System.out.print(min_stack.get(i) + " ") ;
    	}
    	System.out.println("") ;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */