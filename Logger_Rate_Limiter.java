class Logger {

    /** Initialize your data structure here. */
    Map<String,Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp<map.getOrDefault(message,0)){ //If current time stamp less than prvious call time plus ten returen false
            return false;
        }
        map.put(message,timestamp+10); // 10 Seconds from now should not put printed
        return true;

    }
}
