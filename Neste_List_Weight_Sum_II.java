/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 //The idea behind this is keep adding unweight value to the weight
 //Since unweight value contains every integer
 //as we go deeper we add unweight value which contains integer to the weight
 //Time O(N) Space O(N)
class Solution {
    int sum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweight = 0, weight = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextLevel = new ArrayList<>();
            for(NestedInteger n: nestedList){
                if(n.isInteger()) unweight += n.getInteger();
                else nextLevel.addAll(n.getList());
            }
            weight+=unweight;
            nestedList = nextLevel;
        }
        return weight;
    }
}
