class RangeModule {
    Node root;
    public RangeModule() {
        root = new Node(0,Integer.MAX_VALUE);
    }

    public void addRange(int left, int right) {
        root.addRange(left,right);
    }

    public boolean queryRange(int left, int right) {
        return root.queryRange(left,right);
    }

    public void removeRange(int left, int right) {
        root.removeRange(left,right);
    }
    class Node{
        int start, end;
        boolean track;
        Node left,right;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        public Node(int start,int end,boolean track){
            this.start = start;
            this.end = end;
            this.track = track;
        }
        public void addRange(int start, int end){
            if(this.track || start > end || this.end <= start || this.start >= end) return;
            if(this.start >= start && this.end <= end){
                removeLeftRight(true);
            }else{
                if(this.end - this.start <= 1) return;
                int mid = (this.end+this.start) >>> 1;
                left = left == null? new Node(this.start,mid):left;
                right = right == null? new Node(mid,this.end):right;
                left.addRange(start,end);
                right.addRange(start,end);

                if(left.track && right.track){
                    removeLeftRight(true);
                }
            }
        }
        public boolean queryRange(int start, int end){
            if(this.track || this.start >= end || this.end <= start) return true;
            if(this.left == null || this.right == null) return false;
            return this.left.queryRange(start,end) && this.right.queryRange(start,end);
        }
        public void removeRange(int start,int end){
            if(start > end || this.end <= start || this.start >= end) return;
            if(this.start >= start && this.end <= end) {
                removeLeftRight(false);
            }else if(this.end - this.start <= 1){
                this.track = false;
            }
            else{
                if(this.track){
                    this.track = false;
                    int mid = (this.end+this.start)>>> 1;
                    left = left == null? new Node(this.start,mid,true):left;
                    right = right == null? new Node(mid,this.end,true):right;
                }
                    if(this.left == null || this.right == null) return;
                    left.removeRange(start,end);
                    right.removeRange(start,end);

                if(!this.left.track && this.left.left == null && !this.right.track && this.right.right == null){
                    removeLeftRight(false);
                }
            }
        }

        private void removeLeftRight(boolean tracked){
            this.left = null;
            this.right = null;
            this.track = tracked;
        }
    }
}
