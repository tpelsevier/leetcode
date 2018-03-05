class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = q.size();
        q.offer(x);
        while(size -- > 0) q.offer(q.poll()); //Move the val that just add to the queue to the front
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
