/*Time O(N) Space O(N)
Pre = [3,9,20,15,7]
In = [9,3,15,20,7]
   
*/

class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(0,0,inorder.length-1,preorder,inorder);
    }
    private TreeNode helper(int preStart, int inStart, int inEnd,int [] preorder, int[] inorder){
        if(preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int ri = map.get(root.val);// Get the index of current root in the inorder array
        //Pre start +1 equals to plus one , and inStart stays the same, inend ends the index before the root
        root.left = helper(preStart+1,inStart,ri-1,preorder,inorder);
        /*
          Pre start plus equals to current root index in the inorder minus instart+1
          Since inorder minus instart +1 equals to how many children are there in the left
          The in start starts from the right of the current root index in inorder array
        */
        root.right = helper(preStart + (ri-inStart+1),ri+1,inEnd,preorder,inorder);
        return root;
    }
}
