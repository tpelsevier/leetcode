class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        Map<Character,Set<Character>> graph = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();
        String result = "";
        for(String word: words){
            for(char c: word.toCharArray()) indegree.put(c,0);
        }
        for(int i = 0; i < words.length-1;i++){
            String curr = words[i];
            String next = words[i+1];
            int len = Math.min(curr.length(),next.length());
            for(int j = 0; j < len;j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    if(!graph.containsKey(c1)) graph.put(c1,new HashSet<>());
                    if(graph.get(c1).add(c2)){
                        indegree.put(c2,indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new ArrayDeque<>();
        for(char c: indegree.keySet()){
            if(indegree.get(c) == 0) queue.offer(c);
        }
        while(!queue.isEmpty()){
            char c = queue.poll();
            result+=c;
            if(graph.containsKey(c)){
                for(char next: graph.get(c)){
                    indegree.put(next,indegree.get(next)-1);
                    if(indegree.get(next) == 0) queue.offer(next);
                }
            }
        }

        return result.length() == indegree.size()? result.toString(): "";
    }
}
