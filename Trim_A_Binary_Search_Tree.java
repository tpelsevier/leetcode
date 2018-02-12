//Time O(N) Space O(1)
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val < L) return trimBST(root.right,L,R); //This means both nodes are located on the right side of the root
        if(root.val > R) return trimBST(root.left,L,R); //This means both nodes are located on the left side of the root
        root.left = trimBST(root.left,L,R); //
        root.right = trimBST(root.right,L,R);//
        return root;//Finally return the root node
    }
}

/*
          1                 L = 1 R =5
        /   \               Init It skips all the if statements
      -1    3               Then it went to find the left
          /   \             left stop at first if statement which root.val <L
        2     5             Then it went to find the right
                            Repeating the step it find the left 



*/
