//Time O(N) Space O(N)
class Solution {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        findRange(root,0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = min;i<=max;i++){
            res.add(new ArrayList<Integer>());
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        queue.offer(root);
        idx.offer(-min);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            int id = idx.poll();
            res.get(id).add(t.val);
            if(t.left != null){
                queue.offer(t.left);
                idx.offer(id-1);
            }
            if(t.right!=null){
                queue.offer(t.right);
                idx.offer(id+1);
            }
        }
        return res;
    }
    public void findRange(TreeNode root, int pos){
        min = Math.min(min,pos);
        max = Math.max(max,pos);
        if(root.left != null) findRange(root.left,pos-1);
        if(root.right != null) findRange(root.right,pos+1);
    }
}
