class Solution {
    public int repeatedStringMatch(String a, String b) {
        int ans=1;
        boolean res=a.contains(b);
        String temp=a;
        while(!res){
            if(a.length()>=b.length())break;;
            a+=temp;
            ans++;
            res=a.contains(b);
        }
        if(a.contains(b))
            return ans;
        
        a+=temp;
        if(a.contains(b))
            return ans+1;
        else return -1;
        
        
    }
}