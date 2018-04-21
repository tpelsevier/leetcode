//Time O(LogN) Space O(1)
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx < tx && sy < ty){
            if(ty<tx) tx%=ty;
            else ty%=tx;
        }
        return (sx == tx && (ty-sy) % sx == 0)|| (sy == ty && (tx-sx) % sy == 0);
    }
}
