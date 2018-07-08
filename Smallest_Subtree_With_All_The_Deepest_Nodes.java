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

//Time O(N) Space O(N)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        HashMap<TreeNode,int[]> map = new HashMap<>();
        int left = 0, right = 0;
        if(root.left != null) left = findDepth(root.left,map);
        if(root.right != null) right = findDepth(root.right,map);
        return left == right? root:left > right?dfs(root.left,map):dfs(root.right,map);
    }
    private TreeNode dfs(TreeNode root,Map<TreeNode,int[]> map){
        int[] val = map.get(root);
        if(val[0] == val[1]) return root;
        return val[0] > val[1]? dfs(root.left,map):dfs(root.right,map);
    }
    private int findDepth(TreeNode root,Map<TreeNode,int[]> map){
        if(root == null) return 0;
        int left = 0,right = 0;
        if(root.left != null) left = findDepth(root.left,map);
        if(root.right != null) right = findDepth(root.right,map);
        map.put(root,new int[]{left,right});
        return Math.max(left,right)+1;
    }
}
