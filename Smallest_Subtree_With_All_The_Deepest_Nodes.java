/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time O(N+V+E) Space O(N)
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return root;
        HashMap<TreeNode,List<TreeNode>> map = new HashMap<>();
        List<List<TreeNode>> counter = new ArrayList<>();
        counter.add(new ArrayList<>(Arrays.asList(root)));
        if(root.left != null) find(root.left,root,1,counter,map);
        if(root.right != null) find(root.right,root,1,counter,map);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<>();
        for(TreeNode node: counter.get(counter.size()-1)){
            queue.offer(node);
            visited.add(node);
        }
        while(queue.size() > 1){
            int size = queue.size();
            for(int i = 0; i < size;i++){
                TreeNode curr = queue.poll();
                if(map.get(curr) == null) continue;
                for(TreeNode next: map.get(curr)){
                    if(visited.add(next)){
                        queue.offer(next);
                    }
                }
            }
        }
        return queue.poll();
    }
    private void find(TreeNode child, TreeNode parent, int level, List<List<TreeNode>> counter, Map<TreeNode,List<TreeNode>> map){
        if(counter.size() == level) counter.add(new ArrayList<>());
        counter.get(level).add(child);
        map.computeIfAbsent(child,(x) -> new ArrayList<TreeNode>()).add(parent);
        if(child.left != null) find(child.left,child,level+1,counter,map);
        if(child.right != null) find(child.right,child,level+1,counter,map);
    }
}
