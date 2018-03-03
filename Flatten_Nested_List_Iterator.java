/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 //Time O(N) for grab everything, Space O(N)
public class NestedIterator implements Iterator<Integer> {

    List<Integer> ls = new ArrayList<>();
    int index = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        //Flatten everything first
        grab(nestedList);
    }

    public void grab(List<NestedInteger> nestedList){
        for(int i = 0; i < nestedList.size();i++){
            if(!nestedList.get(i).isInteger()) grab(nestedList.get(i).getList());
            else ls.add(nestedList.get(i).getInteger());
        }
    }
    @Override
    public Integer next() {
        return ls.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index != ls.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
