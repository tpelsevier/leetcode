public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int ind = 4; //Keep track of the index for the buffer
    int end = 0; //The end point of the buffer
    char[] buf4 = new char[4];
    public int read(char[] buf, int n) {
        int count = 0;
        while(count < n){ //While the count does not need
            if(ind == 4){
                end = read4(buf4);
                ind = 0;
            }
            if(ind < end){ //If the current index less than end
                buf[count++] = buf4[ind++];
            }else break;
        }
        return count;
    }
}
