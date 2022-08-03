class node{
    int start;
    int end;
    node left;
    node right;
    node(int s,int e){
        start=s;
        end=e;
        left=null;
        right=null;
    }
}
class MyCalendar {
    node root;
    public MyCalendar() {
        this.root =null;
    }
    public boolean insert(node n,int s,int e){
        if(e<=n.start){
            if(n.left==null){
                n.left=new node(s,e);
                return true;
            }
            else{
               return insert(n.left,s,e);
            }
        }
        else if(s>=n.end){
            if(n.right==null){
                n.right=new node(s,e);
                return true;
            }
            else{
               return insert(n.right,s,e);
            }
        }
        return false;
    }
    public boolean book(int start, int end) {
        if(root==null){
            root = new node(start,end);
            return true;
        }
        else{
           return insert(root,start,end);
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */