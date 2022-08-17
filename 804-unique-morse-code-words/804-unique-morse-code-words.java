class Solution {
    public int uniqueMorseRepresentations(String[] words) {
     String[] morseCodes = {
        ".-",
        "-...",
        "-.-.",
        "-..",
        ".",
        "..-.",
        "--.",
        "....",
        "..",
        ".---",
        "-.-",
        ".-..",
        "--",
        "-.",
        "---",
        ".--.",
        "--.-",
        ".-.",
        "...",
        "-",
        "..-",
        "...-",
        ".--",
        "-..-",
        "-.--",
        "--.."
    };
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<words.length;i++){
            String s="";
            String str=words[i];
            for(int j=0;j<str.length();j++){
                s+=morseCodes[str.charAt(j)-'a'];
            }
            hs.add(s);
        }
        return hs.size();
    }
}