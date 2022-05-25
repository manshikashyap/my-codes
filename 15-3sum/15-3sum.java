class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
         Arrays.sort(arr);
        List<List<Integer>> res=new LinkedList<>();
        for(int i=0;i<arr.length-2;i++){
            if(i==0||(arr[i]!=arr[i-1]))//to avoid repetation
            {
                int lo=i+1;
                int hi=arr.length-1;
                int sum=0-arr[i];
                while(lo<hi){
                    if(sum==arr[lo]+arr[hi]){
                    res.add(Arrays.asList(arr[i],arr[lo],arr[hi]));
                        //to avoid repetation
                        while(lo<hi&&arr[lo]==arr[lo+1])lo++;
                        while(lo<hi && arr[hi]==arr[hi-1])hi--;
                        lo++;
                        hi--;
                    }
                    else if(sum<arr[lo]+arr[hi]){
                        hi--;
                    }
                    else{
                        lo++;
                    }
                }
            }   
                
        }
        return res;
    }
}