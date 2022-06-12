class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int size;
    HashMap<Integer,Node> hm;
    public LRUCache(int capacity) {
        hm= new HashMap<>();
        head.next=tail;
        tail.prev=head;
        size=capacity;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key))return -1;
        Node node =hm.get(key);
        remove(node);
        insert(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            remove(hm.get(key));
        }
        if(hm.size()==size){
            remove(tail.prev);
            insert(new Node(key,value));
        }
        else insert(new Node(key,value));
    }
    class Node{
        Node next,prev;
        int key,value;
        Node(int k,int v){
            key =k;
            value=v;
        }
    }
    void remove(Node node){
        hm.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    void insert(Node node){
        hm.put(node.key,node);
        Node n=head.next;
        head.next=node;
        node.prev=head;
        n.prev=node;
        node.next=n;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */