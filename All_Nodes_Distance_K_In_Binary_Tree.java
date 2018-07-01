/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Time O(N+K) Space O(N)
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        if(root.left != null) {
            map.computeIfAbsent(root.val,(x) -> new ArrayList<>()).add(root.left.val);
            buildGraph(root.left,root,map);
        }
        if(root.right != null) {
            map.computeIfAbsent(root.val,(x) -> new ArrayList<>()).add(root.right.val);
            buildGraph(root.right,root,map);
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(target.val);
        visited.add(target.val);
        while(!queue.isEmpty()) {
            if(K == 0) {
                while(!queue.isEmpty()) res.add(queue.poll());
                break;
            }
            int size = queue.size();
            for(int i = 0; i < size;i++) {
                int curr = queue.poll();
                if(!map.containsKey(curr)) continue;
                for(int next: map.get(curr)){
                    if(!visited.add(next)) continue;
                    queue.offer(next);
                }
            }
            K--;
        }
        return res;
    }
    private void buildGraph(TreeNode child,TreeNode parent,HashMap<Integer,List<Integer>> map) {
        map.computeIfAbsent(child.val, (x) -> new ArrayList<>()).add(parent.val);
        if(child.left != null){
            map.get(child.val).add(child.left.val);
            buildGraph(child.left,child,map);
        }
        if(child.right != null){
            map.get(child.val).add(child.right.val);
            buildGraph(child.right,child,map);
        }
    }
}
