//Time O(N) Space O(N)
class LogSystem {
    List<String[]> timetamps = new LinkedList<>();
    Map<String,Integer> map = new HashMap<>();
    public LogSystem() {
        map.put("Year",4);
        map.put("Month",7);
        map.put("Day",10);
        map.put("Hour",13);
        map.put("Minute",16);
        map.put("Second",19);
    }

    public void put(int id, String timestamp) {
        timetamps.add(new String[]{Integer.toString(id), timestamp});
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new LinkedList<>();
        int index = map.get(gra);
        for(String[] time: timetamps){
            String var = time[1].substring(0,index);
            if(var.compareTo(s.substring(0,index)) >= 0 && var.compareTo(e.substring(0,index)) <= 0) res.add(Integer.parseInt(time[0]));
        }
        return res;
    }
}
