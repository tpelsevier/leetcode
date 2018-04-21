//Time O(N) Space O(N)
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int min = Integer.MAX_VALUE;
        List<String> ls = new ArrayList<>();
        for(int i = 0; i < list2.length;i++){
            Integer s = map.get(list2[i]);
            if(s != null){
                if(s+i == min){
                    ls.add(list2[i]);
                }
                else if(s+i < min){
                    ls.clear();
                    ls.add(list2[i]);
                    min = s+i;
                }
            }
        }
        String[] res = new String[ls.size()];
        for(int i =0;i<ls.size();i++) res[i] = ls.get(i);
        return res;
    }
}
