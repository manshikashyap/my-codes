class Solution {
    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> q= new LinkedList<>();
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        q.add(0);
        for(int i=1;i<dp.length;i++){
           if(q.getFirst()<i-k)q.removeFirst();
            dp[i]=dp[q.getFirst()]+nums[i];
            while(q.size()>0 && dp[q.getLast()]<=dp[i])q.removeLast();
            q.addLast(i);
        }
        return dp[nums.length-1];
    }
}