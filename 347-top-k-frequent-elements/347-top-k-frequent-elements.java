class Solution {
    class map implements Comparable<map>{
        public int val;
        public int c;
        public map(int v,int cc){
            val=v;
            c=cc;
        }
        public int compareTo(map other) {
            return other.c - this.c;
        }
    };
  
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans= new int[k];
         if(nums.length==1){
             ans[0]=nums[0];
             return ans;
         }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<map> p = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int val=pq.poll();
        int c=1;
        while(pq.size()>0){
            if(val==pq.peek()){
                pq.remove();
                c++;
            }
            else{
                p.add(new map(val,c));
                c=1;
                val=pq.poll();
            }
            
        }
        p.add(new map(val,c));
        while(k>0){
            map m= p.poll();
            ans[k-1]=m.val;
            k--;
        }
        return ans;
    }
}