public class Template{

	//Driver Method
	public static void main(String[] args){

		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(5);
		root.left = new TreeNode(5);
	}

    	int max = 0;
    	public int longestUnivaluePath(TreeNode root) {
        	if(root != null) dfs(root,root.val);
        	return max;
    	}
    	private int dfs(TreeNode root, int val){
        	if(root == null) return 0;
        	int left = dfs(root.left,root.val);
        	int right = dfs(root.right,root.val);
        	max = Math.max(max,left+right);       
        	return root.val == val? Math.max(left,right)+1:0;
    	}

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}

}
