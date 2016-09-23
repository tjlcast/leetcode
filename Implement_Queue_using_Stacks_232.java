class MyQueue {
    // Push element x to the back of queue.
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    private Stack<Integer> stack = new Stack<Integer>() ;
    
    public void push(int x) {
        this.stack.push(x) ;
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> tempStack = new Stack<Integer>() ;
        
        while(stack.size() != 0) {
            int i = stack.pop() ;
            tempStack.push(i) ;
        }
        
        tempStack.pop() ;
        
        while(tempStack.size() != 0) {
            int i = tempStack.pop() ;
            stack.push(i) ;
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> tempStack = new Stack<Integer>() ;
        
        while(stack.size() != 0) {
            int i = stack.pop() ;
            tempStack.push(i) ;
        }
        
        int top = tempStack.peek() ;
        
        while(tempStack.size() != 0) {
            int i = tempStack.pop() ;
            stack.push(i) ;
        }
        
        return top ;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty() ;
    }
}
