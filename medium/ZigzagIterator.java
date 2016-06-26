public class ZigzagIterator1 {
    
    private Iterator<Integer> i, j, k;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v1.iterator();
        j = v2.iterator();
    }

    public int next() {
        if(i.hasNext()) {
            k = j;
            j = i;
            i = k;
        }
        return j.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
public class ZigzagIterator2 {
    
    private Queue<Iterator> q = null;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<Iterator>();
        if(!v1.isEmpty()) {
            q.add(v1.iterator());
        }
        if(!v2.isEmpty()) {
            q.add(v2.iterator());
        }
    }

    public int next() {
        Iterator ite = q.poll();
        int res = (int)ite.next();
        if(ite.hasNext()) {
            q.add(ite);
        }
        return res;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 
