class Solution {
    public int removePalindromeSub(String s) {
         
        if (s.length()==0){
            return 0;
        }
        int n=s.length();
        
        for (int i=0; i<(n/2); i++){
            if (s.charAt(i) != s.charAt(n-1-i)){
                return 2;
            }
        }return 1;
    }
}