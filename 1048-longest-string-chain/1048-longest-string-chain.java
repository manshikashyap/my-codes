class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a,b) -> a.length() - b.length()); 
        
        int n=words.length;
        int[] dp=new int[n];
        
        Arrays.fill(dp,1); 
        int max=1;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (check(words[i],words[j])) {
                    dp[i]=Math.max(dp[i], 1+dp[j]);
                }
            }
            
            max=Math.max(max,dp[i]);
        }
        
        return max;
    }
    
    boolean check(String a, String b) {
        
        int len1=a.length(), len2=b.length();
        
        if (len1!=len2+1) {
            return false;
        }
        
        boolean flag=false;
        
        int i=0, j=0;
        
        while (i<len1 && j<len2) {
            if (a.charAt(i)==b.charAt(j)) {
                i++;
                j++;
            } else {
                
                if (flag) {
					// this will make sure if we are encountering the violation for the first tiem or not.
                    return false;
                }
                
                flag=true;
                i++;
            }
        }
        
        return true;
    }
}