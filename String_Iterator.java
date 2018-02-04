//Time O(n) Space O(n)
class StringIterator {
    char[] array;
    int rep;
    char ch;
    int i;
    String s;
    public StringIterator(String s) {
        array = s.toCharArray();
        this.s = s;
    }

    public char next() {
        if(rep > 0){
            rep --;
            return ch;
        }else if(i < array.length){
            ch = array[i];
            int j = i +1;
            while(j < array.length && Character.isDigit(array[j]))j++; //Find the count
            rep = Integer.parseInt(s.substring(i+1,j)); //Convert to Integer
            rep --; //Minus one since return one char
            i = j; // i = j means next character
            return ch;
        }else{
            return ' ';
        }

    }

    public boolean hasNext() {
        return rep > 0 || i < array.length;
    }
}
