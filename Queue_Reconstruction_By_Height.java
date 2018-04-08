//Time O(NlogN + N) Space O(1)
//Pick up the tallest guy with 0 people in front of him
//Pick up the second tallest guy in the right position
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> a[0] == b[0]? a[1] - b[1]: b[0]-a[0]);
        LinkedList<int[]> ls = new LinkedList<>();
        for(int[] p: people) ls.add(p[1],p);
        return ls.toArray(new int[ls.size()][]);

    }
}
