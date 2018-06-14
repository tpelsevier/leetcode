//Time O(logN) Peek O(1) Space O(1)
class MaxStack {

    /** initialize your data structure here. */
    DoubleLinkedList doubleLinkedList;
    TreeMap<Integer,List<Node>> tm;
    public MaxStack() {
        doubleLinkedList = new DoubleLinkedList(); //Create a double linked list
        tm = new TreeMap<>();
    }
    //Add to the max stack
    public void push(int x) {
        Node get = doubleLinkedList.add(x);
        if(!tm.containsKey(x)) tm.put(x,new ArrayList<>());
        tm.get(x).add(get);
    }

    public int pop() {
        int val = doubleLinkedList.pop();
        List<Node> ls = tm.get(val);
        ls.remove(ls.size()-1);
        if(ls.size() == 0) tm.remove(val);
        return val;
    }

    public int top() {
        return doubleLinkedList.peek();
    }

    public int peekMax() {
        return tm.lastKey();
    }

    public int popMax() {
        int val = peekMax();
        List<Node> ls = tm.get(val);
        Node node = ls.remove(ls.size()-1);
        doubleLinkedList.unlink(node);
        if(ls.isEmpty()) tm.remove(val);
        return val;
    }
    class DoubleLinkedList{
        Node head;
        Node tail;
        public DoubleLinkedList(){
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }
        public Node add(int x){
            Node val = new Node(x);
            val.next = tail;
            val.prev = tail.prev;
            tail.prev = tail.prev.next = val;
            return val;
        }
        public int peek(){
            return tail.prev.val;
        }
        public int pop(){
            return unlink(tail.prev).val;
        }
        public Node unlink(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            return x;
        }
    }
    class Node{
        Node next = null;
        Node prev = null;
        int val;
        public Node(int val){
            this.val = val;
        }
    }
}
