class Solution {
    List<List<String>> res = new ArrayList<>();
    HashMap<String,List<String>> tree = new HashMap<>(); //Store the DFS Path by BFS
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return res;
        HashSet<String> un = new HashSet<>(wordList);
        HashSet<String> v = new HashSet<>();
        un.remove(beginWord);
        v.add(beginWord);
        boolean found = false;
        Queue<String> dq = new ArrayDeque<>();
        dq.offer(beginWord);
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i = 0; i < size;i++){
                String word = dq.poll();
                for(int j = 0; j < word.length();j++){
                    char[] arr = word.toCharArray();
                    for(char z = 'a'; z <='z';z++){
                        arr[j] = z;
                        String newWord = new String(arr);
                        if(un.contains(newWord)){ //If new word is unvisted
                            if(v.add(newWord)){ //if word is visited in this level
                                dq.offer(newWord);
                            }
                            if(!tree.containsKey(newWord)) tree.put(newWord,new ArrayList<>());
                            tree.get(newWord).add(word);
                        }
                        if(newWord.equals(endWord)) found = true;
                    }
                }
            }
            if(found) break;
            un.removeAll(v);
            v.clear();
        }
        dfs(new ArrayList<>(), beginWord,endWord);
        return res;
    }
    private void dfs(List<String> path, String startWord, String key){
        if(key.equals(startWord)){
            path.add(0,startWord);
            res.add(new ArrayList<>(path));
            path.remove(0);
            return;
        }
        path.add(0,key);
        if(tree.containsKey(key)){
            for(String s: tree.get(key)){
                dfs(path,startWord,s);
            }
        }
        path.remove(0);
    }
}
