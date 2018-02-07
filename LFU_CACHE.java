//Time O(1) Space O(N)
class LFUCache {
    Map<Integer,Integer> vals;
    Map<Integer,Integer> counts;
    Map<Integer,LinkedHashSet<Integer>> cl;
    int min = -1;
    int cap;
    public LFUCache(int capacity) {
        vals = new HashMap<>();
        counts = new HashMap<>();
        cl = new HashMap<>();
        cap = capacity;
        cl.put(1,new LinkedHashSet<>());
    }

    public int get(int key) {
        if(!vals.containsKey(key)) return -1;
        int count = counts.get(key);
        counts.put(key,count+1);
        cl.get(count).remove(key);
        if(min == count && cl.get(min).size()==0){
            min ++;
        }
        if(!cl.containsKey(count+1)) cl.put(count+1,new LinkedHashSet<>());
        cl.get(count+1).add(key);
        return vals.get(key);
    }
    public void put(int key, int value) {
        if(cap <= 0) return;
        if(vals.containsKey(key)){ //If vals has the key, no space changed need
            get(key);
            vals.put(key,value);
            return;
        }
        if(vals.size() == cap){
            int evic = cl.get(min).iterator().next();//Remove from the first value min freq value set
            vals.remove(evic);
            cl.get(min).remove(evic);
            counts.remove(evic);
        }
        //It is a new value, so frequency is 1
        vals.put(key,value);
        counts.put(key,1);
        cl.get(1).add(key);
        min = 1;
    }
}
