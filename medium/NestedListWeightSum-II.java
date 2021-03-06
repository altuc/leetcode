/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution1 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.isEmpty()) {
            return 0;
        }
        Queue<NestedInteger> q = new LinkedList<NestedInteger>();
        for(NestedInteger ni : nestedList) {
            q.add(ni);
        }
        int sum = 0;
        int cur = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                NestedInteger ni = q.poll();
                if(ni.isInteger()) {
                    cur += ni.getInteger();
                } else {
                    q.addAll(ni.getList());
                }
            }
            sum += cur;
        }
        return sum;
    }
}

public class Solution2 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.isEmpty()) {
            return 0;
        }
        Queue<NestedInteger> q = new LinkedList<NestedInteger>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(NestedInteger ni : nestedList) {
            q.add(ni);
        }
        int sum = 0;
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                NestedInteger ni = q.poll();
                if(ni.isInteger()) {
                    if(!map.containsKey(level)) {
                        map.put(level, new ArrayList<Integer>());
                    }
                    map.get(level).add(ni.getInteger());
                } else {
                    q.addAll(ni.getList());
                }
            }
            level++;
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for(int i : entry.getValue()) {
                sum += (level - entry.getKey()) * i;
            }
        }
        return sum;
    }
}
