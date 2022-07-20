class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String,Integer> hm= new HashMap<>();
        int ans=0;
        for(String str:words){
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        char ch[]= s.toCharArray();
        for(String str:hm.keySet()){
            char[] temp=str.toCharArray();
            int i=0;
            int j=0;
            while(i<ch.length&& j<temp.length){
                if(ch[i]==temp[j]){
                    i++;
                    j++;
                }
                else{
                    i++;
                }
            }
            if(j==temp.length){
                ans+=hm.get(str);
            }
        }
        return ans;
    }
}