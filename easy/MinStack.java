public class MinStack {

    Stack<Integer> sta = null;
    Stack<Integer> min = null;
    
    /** initialize your data structure here. */
    public MinStack() {
        sta = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        sta.push(x);
        if(min.empty() || min.peek() >= x) {
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
