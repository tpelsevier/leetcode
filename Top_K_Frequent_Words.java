//Time O(n Logk) Space O(N) Each insertion in a priority queue is LogK, Worst case over all words
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        LinkedList<String> ls = new LinkedList<>();
        for(String word:words){
            if(!map.containsKey(word)) map.put(word,1);
            else map.put(word,map.get(word)+1);
        }
        //Priority queue, sort the count small to big and the string lexicographically big to small
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()): a.getValue()-b.getValue());
        for(Map.Entry<String,Integer>m: map.entrySet()){
            pq.offer(m);
            if(pq.size()>k) pq.poll();
        }
        while(!pq.isEmpty()) ls.addFirst(pq.poll().getKey());
        return ls;
    }
}
