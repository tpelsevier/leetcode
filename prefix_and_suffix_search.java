//Time O(N*K) K = String.length Space O(NK)
class WordFilter {
    class Node {
        Map<Character,Node> children = new HashMap<>();
        String word;
        int weight = -1;
    }
    Node root;
    HashMap<String,Integer> map;
    int ans = -1;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        root = buildTrie(words);
    }
    
    private Node buildTrie(String[] words) {
        Node root = new Node();
        int i = 0;
        for(String word: words) {
            Node travel = root;
            for(char c: word.toCharArray()) {
                travel.children.putIfAbsent(c,new Node());
                travel = travel.children.get(c);
                travel.weight = i;
            }
            map.put(word,i++);
            travel.word = word;
        }
        return root;
    }
    
    public int f(String prefix, String suffix) {
        Node node = findPrefix(root,prefix);
        if(node == null) return -1;
        ans = -1;
        findSuffix(node,suffix);
        return ans;
    }
    
    private Node findPrefix(Node root, String prefix) {
        for(char c: prefix.toCharArray()) {
            if(root.children.get(c) == null) return null;
            root = root.children.get(c);
        }
        return root;
    }
    private void findSuffix(Node root, String suffix) {
        if(root.word != null){
            if(root.word.endsWith(suffix)) {
                ans = Math.max(ans,map.get(root.word));
            }
        }else{
            for(Map.Entry<Character,Node> entry: root.children.entrySet()) {
                findSuffix(entry.getValue(),suffix);
            }
        }
    }
}

