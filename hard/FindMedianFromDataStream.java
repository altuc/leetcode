public class MedianFinder {
    
    PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if(max.size() < min.size()) {
            max.add(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return max.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
