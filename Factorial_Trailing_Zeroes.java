//Time O(LOG(N)) space O(1)
class Solution {
    public int trailingZeroes(int n) {
        return n == 0? 0 : n/5+trailingZeroes(n/5);
    }
}
