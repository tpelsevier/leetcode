//Time O(N) Space O(N)
class Solution {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedInteger deserialize(String s) {
        if(s.isEmpty()) return new NestedInteger();
        NestedInteger curr = null;
        if(s.charAt(0) != '['){
            return new NestedInteger(Integer.valueOf(s));
        }
        int l = 0;
        for(int r = 0; r < s.length();r++){
            char c = s.charAt(r);
            if(c == '['){
                if(curr != null) stack.push(curr);
                curr = new NestedInteger();
                l = r+1;
            }
            else if(c == ']'){
                String num = s.substring(l,r);
                if(!num.isEmpty()) curr.add(new NestedInteger(Integer.valueOf(num)));
                if(!stack.isEmpty()){
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r+1;
            }
            else if(c == ','){
                if(s.charAt(r-1) != ']') {
                    String num = s.substring(l,r);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                l = r+1;
            }
        }
        return curr;
    }
}
