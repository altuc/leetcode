public class Vector2D implements Iterator<Integer> {
    
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

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
