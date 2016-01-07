class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
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
