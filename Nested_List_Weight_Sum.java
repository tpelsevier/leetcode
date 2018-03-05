//Time O(N) Space O(1)
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList,1);
    }
    public int depthSum(List<NestedInteger> nestedList,int level){
        int sum = 0;
        for(NestedInteger n: nestedList){
            if(!n.isInteger()){
                sum += depthSum(n.getList(),level+1);
            }else sum += n.getInteger() * level;
        }
        return sum;
    }
}
