class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        k=nums.length-k;
        while(k>0){
            pq.remove();
            k--;
        }
        return pq.peek();
    }
}