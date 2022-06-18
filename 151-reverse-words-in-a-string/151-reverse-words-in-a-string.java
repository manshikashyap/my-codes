class Solution {
    public String reverseWords(String s) {
        String ans="";
        int n =s.length();
        int i=0;
        while(i<n){
            while(i<n && s.charAt(i)==' ')i++;
            int j=i+1;
            while(j<n && s.charAt(j)!=' ')j++;
            String w="";
            if(i<n && j<=n){
                w=s.substring(i,j);
                if(ans.length()==0)ans+=w;
                else ans=w+' '+ans;
            }
            
            i=j+1;
        }
        return ans;
    }
}