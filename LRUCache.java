//Time O(1) Space O(N)
class LRUCache {
    HashMap<Integer,Node> hm;
    Node head; //The most outdated
    Node tail; //The most recent
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

    public void put(int key, int val) { //This is why we need hash map data structure
        if(hm.get(key) != null){ //If the key existed before
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
        }else{ //If it is a new key
            Node n = new Node(key,val);
            if(capacity == 0){ //Verify if this LRU cache has enough capacity
                hm.remove(head.key);
                head = head.next;
                capacity ++;
            }
            if(head == null && tail == null){ //If the linked list is null
                head = n;
            }else{
                tail.next = n;
                n.prev = tail;
            }
            tail = n;
            capacity --; // reduce the capacity
            hm.put(key,n);
        }
    }
    //Double linked list class
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
