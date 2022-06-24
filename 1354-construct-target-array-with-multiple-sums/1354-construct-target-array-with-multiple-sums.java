class Solution {
    public boolean isPossible(int[] tar) {
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(int n:tar){
            pq.add((long)n);
            sum+=n;
        }
        while(pq.peek()!=1){
            long top=pq.poll();
            sum=sum-top;
            if(sum<=0 || sum>=top)return false;
            top=top%sum;
            sum+=top;
            pq.offer(top>0?top:sum);
        }
        return true;
    }
}