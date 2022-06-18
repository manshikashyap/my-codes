class WordFilter {
    HashMap<String,Integer> hm;
    public WordFilter(String[] words) {
        int idx=0;
        hm=new HashMap<>();
        for(String word:words){
            for(int i=0;i<=word.length();i++){
                for(int j=0;j<word.length();j++){
                    String mw=word.substring(0,i)+'#'+word.substring(j);
                    hm.put(mw,idx);
                }
            }
            idx++;
        }
    }
    
    public int f(String prefix, String suffix) {
        String s=prefix+'#'+suffix;
        return hm.getOrDefault(s,-1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */