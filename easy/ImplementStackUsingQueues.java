class MyStack1 {
    
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    
    // Push element x onto stack.
    public void push(int x) {
        if(!q2.isEmpty()) {
            q2.add(x);
        } else {
            q1.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!q2.isEmpty()) {
            while(q2.size() > 1) {
                q1.add(q2.poll());
            }
            q2.poll();
        } else {
            while(q1.size() > 1) {
                q2.add(q1.poll());
            }
            q1.poll();
        }
    }

    // Get the top element.
    public int top() {
        int te = 0;
        if(!q2.isEmpty()) {
            while(q2.size() > 1) {
                q1.add(q2.poll());
            }
            te = q2.poll();
            q1.add(te);
        } else {
            while(q1.size() > 1) {
                q2.add(q1.poll());
            }
            te = q1.poll();
            q2.add(te);
        }
        return te;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

class MyStack2 {
    
    private Queue<Integer> que1 = new LinkedList<Integer>();
    private Queue<Integer> que2 = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        if(que1.isEmpty()) {
            que1.add(x);
        } else {
            que2.add(que1.poll());
            que1.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        que1.poll();
        while(!que2.isEmpty()) {
            que1.add(que2.poll());
        }
        while(que1.size() > 1) {
            que2.add(que1.poll());
        }
    }

    // Get the top element.
    public int top() {
        return que1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return que1.isEmpty() && que2.isEmpty();
    }
}
