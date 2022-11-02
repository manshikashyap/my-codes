class Solution {
    public String removeStars(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*' && st.size()>0)st.pollLast();
            else st.offer(s.charAt(i));
        }
        String ans="";
        while(st.size()>0){
            ans+=st.poll();
        }
        return ans;
    }
}
/*Deque<String> dq = new ArrayDeque<>();
      for(int i = 0; i < s.length(); i ++) {
          char c = s.charAt(i);
          if(c == '*')
          dq.pollLast();

          else
          dq.offer(c + "");
      }
      return String.join("", dq);*/