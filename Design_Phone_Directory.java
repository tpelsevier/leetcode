//Space O(N)
class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    int max;
    HashSet<Integer> used = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    int index = 0;
    public PhoneDirectory(int maxNumbers) {
        this.max = maxNumbers;
        //Time O(N)
        for(int i =0;i<max;i++) q.offer(i);
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() { //O(1)
        if(q.isEmpty()) return -1;
        int n = q.poll();
        used.add(n);
        return n;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) { //Time O(1)
        if(number < 0 || number >= max) return false;
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) { //Time O(1)
        if(used.remove(number)){
            q.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
