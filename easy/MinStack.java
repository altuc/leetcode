public class MinStack {

    private Deque<Integer> sta = null;
    private Deque<Integer> min = null;
    
    /** initialize your data structure here. */
    public MinStack() {
        sta = new ArrayDeque<Integer>();
        min = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        sta.push(x);
        if(min.isEmpty() || min.peek() >= x) {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
