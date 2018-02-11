//Using queue Time O(N) space O(N)
public class BSTIterator {
    Queue<Integer> queue;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        cons(root);
    }
    private void cons(TreeNode root){
        if(root == null) return;
        cons(root.left);
        queue.add(root.val);
        cons(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
}
//Using stack Time O(N) Space O(N)
public class BSTIterator {
    Stack<Integer> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        cons(root);
    }
    private void cons(TreeNode root){
        if(root == null) return ;
        cons(root.right);
        stack.push(root.val);
        cons(root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop();
    }
}
