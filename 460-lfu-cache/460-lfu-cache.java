class LFUCache {
    int cap;
    int csize;
    int f;
    HashMap<Integer,Node> cache;
    HashMap<Integer,LinkedList> freq;
    

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freq = new HashMap<>();
        cap=capacity;
        f=0;
        csize=0;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))return -1;
        Node curn=cache.get(key);
        update(curn);
        return curn.value;
    }
    
    public void put(int key, int value) {
        if(cap==0){
            return;
        }
        if(cache.containsKey(key)){
            Node curr =cache.get(key);
            curr.value=value;
            update(curr);
        }
        else{
            csize++;
            if(csize>cap){
                LinkedList l=freq.get(f);
                cache.remove(l.tail.prev.key);
                l.remove(l.tail.prev);
                csize--;
            }
            f=1;
            Node n=new Node(key,value);
            LinkedList clist=freq.getOrDefault(f,new LinkedList());
            clist.add(n);
            freq.put(f,clist);
            cache.put(key,n);
            
        }
    }
    public void update(Node node){
        int cf=node.frequency;
        LinkedList list =freq.get(cf);
        try{
            list.remove(node);
        }
        catch(NullPointerException e){
            
        }
        
        if(f==cf && list.size==0){
            f++;
        }
        node.frequency++;
        LinkedList temp=freq.getOrDefault(node.frequency,new LinkedList());
        temp.add(node);
        freq.put(node.frequency,temp);
    }
    class Node{
        int key;
        int value;
        int frequency;
        Node next;
        Node prev;
        public Node(int k,int v){
            key=k;
            value=v;
            frequency=1;
        }
    }
    class LinkedList{
        int size;
        Node head;
        Node tail;
        public LinkedList(){
            size=0;
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
        }
        public void add(Node n){
            Node node=head.next;
            n.next=node;
            n.prev=head;
            head.next=n;
            node.prev=n;
            size++;
        }
        public void remove(Node n){
            Node node=n.prev;
            Node n1=n.next;
            node.next=n1;
            n1.prev=node;
            size--;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */