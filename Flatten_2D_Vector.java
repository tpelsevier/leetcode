//Time O(N) Space O(N)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return nums;
        int n = nums.length;
        int [] res = new int[n-k+1];
        int ri = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n;i++){
            while(!dq.isEmpty() && dq.peek() < i-k+1) dq.poll();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.offer(i);
            if(i >= k-1) res[ri++] = nums[dq.peek()];
        }
        return res;
    }
}
//Time O(1) Space O(1)
public class Vector2D implements Iterator<Integer> {
    int li = 0;
    int ei = 0;
    List<List<Integer>> ls;
    public Vector2D(List<List<Integer>> vec2d) {
        ls = vec2d;
    }

    @Override
    public Integer next() {
        return ls.get(li).get(ei++);
    }

    @Override
    public boolean hasNext() {
        while(li < ls.size()){
            if(ei < ls.get(li).size()) return true;
            else{
                li++;
                ei = 0;
            }
        }
        return false;
    }
}
