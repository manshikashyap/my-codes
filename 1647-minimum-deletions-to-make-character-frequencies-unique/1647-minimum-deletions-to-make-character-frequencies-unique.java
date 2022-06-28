class Solution {
    public int minDeletions(String s) {
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            count[ch-'a']++;
        }
        Arrays.sort(count);
        reverse(count);
        int f=count[0];
        int ans=0;
        for(int c:count){
            if(c>f){
                if(f>0)ans+=(c-f);
                else ans+=c;
            }
            f=Math.min((f-1),c-1);
        }
        return ans;
    }
    public void reverse(int[] arr){
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;
            h--;
        }
    }
}