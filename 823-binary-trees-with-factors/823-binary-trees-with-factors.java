class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Long> hm=new HashMap();
        int n=arr.length;
        long ans=1;
        hm.put(arr[0],ans);
        for(int i=1;i<n;i++){
            long sum=1;
            for(int j=0;j<i;j++){
               if(arr[i]%arr[j]==0 && hm.containsKey(arr[i]/arr[j])){
                   sum+=(hm.get(arr[i]/arr[j])*hm.get(arr[j]));
               }
            }
            hm.put(arr[i],sum);
            ans+=sum;
        }
        return (int)(ans%1000000007);
    }
}