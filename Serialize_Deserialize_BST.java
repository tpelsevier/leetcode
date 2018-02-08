//Time O(N) Since every node only visit once. space O(1)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(""),root).toString();
    }
    private StringBuilder serial(StringBuilder sb, TreeNode root){
        if(root == null) {return sb.append(";");}
        sb.append(String.valueOf(root.val)+",");
        serial(sb,root.left).append(",");
        serial(sb,root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<String>(Arrays.asList(data.split(","))));
    }

    private TreeNode deserial(Queue<String> queue){
        String value = queue.poll();
        if(value.equals(";")){return null;}
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = deserial(queue);
        root.right = deserial(queue);
        return root;
    }
}
