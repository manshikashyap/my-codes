class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxl=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int n =s.length();
        int l=0;
        int r=0;
        while(r<n){
             if(hm.containsKey(s.charAt(r))){
                 l=Math.max(l,hm.get(s.charAt(r))+1);
             }
            hm.put(s.charAt(r),r);
            maxl=Math.max(maxl,r-l+1);
            r++;
        }
        return maxl;
            
            
    }
}