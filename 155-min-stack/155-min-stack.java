class Node{
    int val;
    int min;
    Node(int v,Node prev){
        val=v;
        if(prev!=null){
            min=Math.min(prev.min,val);
        }
        else min=val;
            
    }
}
class MinStack {
   private List<Node> stack;
    int size=0;
    public MinStack() {
        stack=new ArrayList<>();
    }
    
    public void push(int val) {
        Node node;
        if(size==0){
            node=new Node(val,null);
        }
        else{
            Node tmp=stack.get(size-1);
            node=new Node(val,tmp);
        }
        stack.add(node);
        size++;
    }
    
    public void pop() {
        stack.remove(size-1);
        size--;
    }
    
    public int top() {
        return stack.get(size-1).val;
    }
    
    public int getMin() {
        return stack.get(size-1).min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */