//Time O(N) Space O(N)
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int n: preorder){
            if(n < min) return false;
            while(!stack.isEmpty() && n > stack.peek()) min = stack.pop();//When top smaller than n, it means it start a right node
            stack.push(n);
        }
        return true;
    }
}

//Time O(N) Space O(1)

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE,top = -1;
        for(int n: preorder){
            if(n < min) return false;
            while(top >= 0 && n > preorder[top]) min = preorder[top--]; //When top smaller than n, it means it start a right node
            preorder[++top] = n;
        }
        return true;
    }
}
