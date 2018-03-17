class MyCalendarTwo {
    List<int[]> cal;
    List<int[]> overlaped; //Keep tracking of the overlap intervals
    public MyCalendarTwo() {
        cal = new ArrayList<>();
        overlaped = new ArrayList<>();
    }
    /*
        5   15
          13   20
      overStart = 13 overend = 15
      overend > over start which result in overlap
    */
    public boolean book(int start, int end) {
        for(int[] s: cal){
            int ovstart = Math.max(start,s[0]), overend = Math.min(end,s[1]);
            if(ovstart < overend){
                for(int[] o: overlaped){
                    if(Math.max(ovstart,o[0]) < Math.min(overend,o[1])){
                       //Clear out the overlap list incase of duplicate overlap
                       //We only compare current start to all the intervals in the cal List
                      // If there is a over lap, check if it overlap with a intervals in the over lap List
                      //Incase of duplicate
                        overlaped.clear();
                        return false;
                    }
                }
                overlaped.add(new int[] {ovstart,overend}); //Add to the double over lap
            }
        }
        cal.add(new int[]{start,end});
        return true;
    }
}
