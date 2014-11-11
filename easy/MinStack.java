class MinStack {
    private Stack<Integer> sta = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        sta.push(x);
        if(min.empty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        int n = sta.pop();
        if(n == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return sta.peek();
    }

    public int getMin() {
        return min.peek();
    }
}