//Time O(N) Space O(N)
//Pre = [3,9,20,15,7]
//In = [9,3,15,20,7]
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i< inorder.length;i++) map.put(inorder[i],i);
        return helper(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    private TreeNode helper(int poEnd, int inStart, int inEnd, int[] inorder, int[] postorder){
        if(poEnd < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[poEnd]);
        int ri = map.get(root.val);

        /*
          poEnd minus equals to the index of inEnd minus current root index in the inorder +1
          Since inEnd minus index of current node +1 equals to how many children are there in the right
          The instart stays the same inEnd from the left of the current root index in inorder array
        */
        root.left = helper(poEnd -(inEnd-ri+1),inStart,ri-1,inorder,postorder);
        //Root.right is always poEnd - 1, the right is the current root index + 1 , inEnd stays the same
        root.right = helper(poEnd-1,ri+1,inEnd,inorder,postorder);
        return root;
    }
}
