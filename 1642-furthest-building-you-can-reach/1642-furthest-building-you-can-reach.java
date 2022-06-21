class Solution {
    public int furthestBuilding(int[] h, int b, int l) {
        int i=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(i=0;i<h.length-1;i++){
            int d=h[i+1]-h[i];
            if(d<=0)continue;
            if(d<=b){
                b-=d;
                pq.offer(d);
            }
            else if(l>0){
                if(pq.size()>0){
                    int x=pq.peek();
                    if(x>d){
                        b+=pq.poll();
                        b-=d;
                        pq.add(d);
                    }
                }
                l--;
            }
            else break;
        }
        return i;
    }
}