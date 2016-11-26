public class MovingAverage {
    
    private Queue<Integer> q = null;
    private int max;
    private double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        if(size <= 0) {
            return;
        }
        q = new LinkedList<Integer>();
        max = size;
        sum = 0;
    }
    
    public double next(int val) {
        if(q.size() == max) {
            sum -= q.poll();
        }
        q.add(val);
        sum += val;
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
