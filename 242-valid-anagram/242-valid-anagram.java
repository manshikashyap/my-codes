class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                int x=hm.get(s.charAt(i));
                hm.put(s.charAt(i),x+1);
            }
            else{
                hm.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!hm.containsKey(ch))return false;
            else{
                int x=hm.get(ch);
                x--;
                if(x==0)hm.remove(ch);
                else{
                    hm.put(ch,x);
                }
            }
        }
        return true;
    }
}