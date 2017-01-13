public class LRUCache {
    
    private int cap;
    private Map<Integer, Node> map = null;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            removeNode(n);
            moveNodeToHead(n);
            return n.value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            removeNode(n);
            moveNodeToHead(n);
        } else {
            if(cap == map.size()) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            } 
            Node n = new Node(key, value);
            map.put(key, n);
            moveNodeToHead(n);
        }
    }
    
    private void moveNodeToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

class Node {
    
    int key;
    int value;
    Node pre;
    Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
