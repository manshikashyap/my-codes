class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int ans=0;
        int[] mask = new int[n];
        for(int i =0;i<words.length;i++){
            for(char c:words[i].toCharArray()){
                mask[i] |=(1<<(c-'a'));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&& (mask[i]&mask[j])==0){
                    ans=Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
}