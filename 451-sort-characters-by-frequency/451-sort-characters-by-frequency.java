class pair implements Comparable<pair>{
    char ch;
    int idx;
    pair(char c,int i){
        ch=c;
        idx=i;
    }
    public int compareTo(pair p){
        return p.idx-idx;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        ArrayList<pair> list=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int c=hm.getOrDefault(ch,0);
            c++;
            hm.put(ch,c);
        }
        for(Map.Entry<Character,Integer> el:hm.entrySet()){
            char ch=el.getKey();
            int cnt=el.getValue();
            list.add(new pair(ch,cnt));
        }
        Collections.sort(list);
        String ans="";
        for(int i=0;i<list.size();i++){
            pair p=list.get(i);
            char ch=p.ch;
            int cnt=p.idx;
            for(int j=0;j<cnt;j++){
                ans+=ch;
            }
        }
        return ans;
    }
}