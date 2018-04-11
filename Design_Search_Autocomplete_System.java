class AutocompleteSystem {
    Map<String,Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    List<Map.Entry<String,Integer>> fullList = new ArrayList<>();
    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i = 0; i < sentences.length;i++) map.put(sentences[i],times[i]);
    }
    public List<String> input(char c) {
        List<String> ans = new ArrayList<>();
        if(c == '#'){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            sb.setLength(0);
            fullList.clear();
        }else{
            sb.append(c);
            String pre = sb.toString();
            if(sb.length() == 1){
                for(Map.Entry<String,Integer> val: map.entrySet()){
                    if(val.getKey().startsWith(pre)) {
                        fullList.add(val);
                    }
                }
                Collections.sort(fullList,(a,b) -> a.getValue() == b.getValue()?a.getKey().compareTo(b.getKey()):b.getValue() - a.getValue());
            }else{
                for (Iterator <Map.Entry <String, Integer>> itr = fullList.iterator(); itr.hasNext();){
                    if(!itr.next().getKey().startsWith(pre))itr.remove();
                }
            }
            for (int idx = 0; idx < 3 && idx < fullList.size(); idx ++) ans.add (fullList.get(idx).getKey ());

        }
        return ans;
    }
}
