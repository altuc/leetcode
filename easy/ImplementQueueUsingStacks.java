class MyQueue1 {
    
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!s2.empty()) {
            s2.pop();
        } else {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            s2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!s2.empty()) {
            return s2.peek();
        } else {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

class MyQueue2 {
    
    private Stack<Integer> sta1 = new Stack<Integer>();
    private Stack<Integer> sta2 = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        if(sta1.empty()) {
            sta1.push(x);
        } else {
            sta2.push(x);
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        sta1.pop();
        if(sta1.empty()) {
            while(!sta2.empty()) {
                sta1.push(sta2.pop());
            }
        }
    }

    // Get the front element.
    public int peek() {
        return sta1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return sta1.empty() && sta2.empty();
    }
}
