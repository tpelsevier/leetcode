//Insert Time (K*L) Space(K*L) 
class MapSum {
    Node root = new Node();
    Set<String> set = new HashSet<>();
    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        Node t = root;
        boolean existed = set.contains(key);
        for(Character c: key.toCharArray()){
            if(t.node[c-'a'] == null) t.node[c-'a'] = new Node();
            t = t.node[c-'a'];
            if(existed) t.sum = val;
            else t.sum += val;
        }
        set.add(key);
    }

    public int sum(String prefix) {
        Node t = root;
        for(Character c: prefix.toCharArray()){
            if(t.node[c-'a'] == null) return 0;
            t=t.node[c-'a'];
        }

        return t.sum;
    }

    class Node{
        Node [] node = new Node[26];
        int sum = 0;
    }
}
