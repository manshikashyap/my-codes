class pair{
    int value;
    int key;
    pair(int k,int v){
        key=k;
        value=v;
    }
}
class StockSpanner {
    Stack<pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int cnt=1;
        while(st.size()>0 && st.peek().key<=price){
            cnt+=st.pop().value;
        }
        st.push(new pair(price,cnt));
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */