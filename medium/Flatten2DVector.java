public class Vector2D1 implements Iterator<Integer> {
    
    private Queue<Integer> q = null;

    public Vector2D(List<List<Integer>> vec2d) {
        q = new LinkedList<Integer>();
        for(List<Integer> ls : vec2d) {
            q.addAll(ls);
        }
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

public class Vector2D2 implements Iterator<Integer> {
    
    private Iterator<List<Integer>> ite1 = null;
    private Iterator<Integer> ite2 = null;

    public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d == null || vec2d.isEmpty()) {
            return;
        }
        ite1 = vec2d.iterator();
        ite2 = ite1.next().iterator();
        while(!ite2.hasNext() && ite1.hasNext()) {
            ite2 = ite1.next().iterator();
        }
    }

    @Override
    public Integer next() {
        int next = ite2.next();
        while(!ite2.hasNext() && ite1.hasNext()) {
            ite2 = ite1.next().iterator();
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        return ite2 != null && ite2.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
