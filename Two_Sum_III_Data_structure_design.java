class TwoSum {

    /** Initialize your data structure here. */
    ArrayList<Integer> ls;
    HashMap<Integer,Integer> map;
    public TwoSum() {
        map = new HashMap<>();
        ls = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        ls.add(number);
        map.put(number,map.getOrDefault(number,0)+1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i = 0;i<ls.size();i++){
            if(value >>1  == ls.get(i)){
                //incase of 0 and 1 so we need to make sure 2 times ls.get(i) equals to the value it self
                //And make sure there are two values in the lists
                if(map.get(ls.get(i)) >= 2 && 2*ls.get(i) == value) return true;
            }else{
                if(map.containsKey(value-ls.get(i))) return true;
            }
        }
        return false;
    }
}
