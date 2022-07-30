class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans=new ArrayList<>();
        int[] c2=new int[26];
        for(String word:words2){
            int l=word.length();
            int[] map=new int[26];
            for(int i=0;i<l;i++){
                char ch=word.charAt(i);
                int idx=ch-'a';
                map[idx]++;
                c2[idx]=Math.max(c2[idx],map[idx]);
            }
        }
        for(String word:words1){
            int l=word.length();
            int[] map=new int[26];
            for(int i=0;i<l;i++){
                char ch=word.charAt(i);
                int idx=ch-'a';
                map[idx]++;
            }
            
            boolean mark=true;
            for(int i=0;i<26;i++){
                if(map[i]<c2[i]){
                    mark=false;
                    break;
                }
                
            }
            if(mark)ans.add(word);
        }
        return ans;
    }
}