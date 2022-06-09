class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;
        int[] idx=new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(numbers[i],i);
        }
        for(int i=0;i<n;i++){
           
                idx[0]=i+1;
                int req=target-numbers[i];
                if(hm.containsKey(req) && hm.get(req)!=i){
                    idx[1]=hm.get(req)+1;
                    return idx;
                }
            }
        
        return idx;
    }
}