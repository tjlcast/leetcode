class MyStack {
    // Push element x onto stack.
    
    Queue<Integer> queue = new LinkedList<Integer>() ;
    
    public void push(int x) {
        queue.offer(x) ;
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> tempQ = new LinkedList<Integer>() ;
        while(!queue.isEmpty()) {
            Integer i = queue.remove() ;
            if (!queue.isEmpty())tempQ.offer(i) ;
        }
        
        while(!tempQ.isEmpty()) {
            Integer i = tempQ.remove() ;
            queue.offer(i) ;
        }
    }

    // Get the top element.
    public int top() {
        int ans = -1 ;
        Queue<Integer> tempQ = new LinkedList<Integer>() ;
        while(!queue.isEmpty()) {
            Integer i = queue.remove() ;
            tempQ.offer(i) ;
            if (queue.isEmpty()) ans = i ;
        }
        
        while(!tempQ.isEmpty()) {
            Integer i = tempQ.remove() ;
            queue.offer(i) ;
        }
        return ans ;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty() ;
    }
}
