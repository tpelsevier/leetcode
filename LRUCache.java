class LRUCache {
    HashMap<Integer,Node> hm;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.hm = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node n = hm.get(key);
        if(n == null) return -1;
        if(n != tail){
            if(n == head){
                head = head.next;
            }else{
                n.prev.next = n.next;
                n.next.prev = n.prev;
            }
            tail.next = n;
            n.prev = tail;
            n.next = null;
            tail = n;

        }
        return n.val;
    }

    public void put(int key, int val) {
        if(hm.get(key) != null){
            Node n = hm.get(key);
            n.val = val;
            if(n != tail){
                if(n == head){
                    head = head.next;
                    head.prev = null;
                }else{
                    n.prev.next = n.next;
                    n.next.prev = n.prev;
                }
                tail.next = n;
                n.prev = tail;
                n.next = null;
                tail = n;
            }
        }else{
            Node n = new Node(key,val);
            if(capacity == 0){
                hm.remove(head.key);
                head = head.next;
                capacity ++;
            }
            if(head == null && tail == null){
                head = n;
            }else{
                tail.next = n;
                n.prev = tail;
            }
            tail = n;
            capacity --;
            hm.put(key,n);
        }
    }

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }

    }
}
