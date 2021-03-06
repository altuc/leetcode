/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private Stack<NestedInteger> sta = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        sta = new Stack<NestedInteger>();
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            sta.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(hasNext()) {
            return sta.pop().getInteger();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        while(!sta.empty()) {
            NestedInteger ni = sta.peek();
            if(ni.isInteger()) {
                return true;
            }
            sta.pop();
            for(int i = ni.getList().size() - 1; i >= 0; i--) {
                sta.push(ni.getList().get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
