class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] r= new int[n-k+1];
        Deque<Integer> q=new ArrayDeque<>();
        int ri=0;
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peek()==i-k)q.poll();
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])q.pollLast();
            q.offer(i);
            if(i>=k-1)r[ri++]=nums[q.peek()];
        }
        return r;
    }
}