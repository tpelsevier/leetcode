/*
Frame: "AXXXAXXXAXXXA"
insert 'B': "ABXXABXXABXXA" <--- 'B' has higher frequency than the other characters, insert it first.
insert 'E': "ABEXABEXABXXA"
insert 'F': "ABEFABEXABFXA" <--- each time try to fill the k-1 gaps as full or evenly as possible.
insert 'G': "ABEFABEGABFGA"
*/
//Time O(N) Space O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char c: tasks) counts[c-'A']++;
        Arrays.sort(counts);
        int i = 25;
        while(i >= 0 && counts[i]== counts[25]) i --;
        return Math.max(tasks.length,(counts[25]-1) * (n+1)+25-i);

    }
}
