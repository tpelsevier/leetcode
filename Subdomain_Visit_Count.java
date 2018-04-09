//Time O(N) Space O(N)
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for(String dom: cpdomains){
            String[] arr = dom.split(" ");
            int times = Integer.parseInt(arr[0]);
            String d = arr[1];
            int p = d.indexOf('.')+1;
            map.put(d,map.getOrDefault(d,0)+times);
            while(p != 0){
                String sub = d.substring(p,d.length());
                map.put(sub,map.getOrDefault(sub,0)+times);
                p = d.indexOf('.',p)+1;
            }
        }
        List<String> res = new ArrayList<>();
        for(String key: map.keySet()){
            res.add(map.get(key)+" "+key);
        }
        return res;
    }
}
