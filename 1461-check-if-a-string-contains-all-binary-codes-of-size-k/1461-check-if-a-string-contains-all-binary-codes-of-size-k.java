class Solution {
    public boolean hasAllCodes(String s, int k) {
        //ArrayList<String> al = gss(k);
        HashSet<String> h=new HashSet<>();
        int n = s.length();
        int total=1<<k;
		for(int i =0; i+k<=n; i++)
		{
		    String ss = s.substring(i,i+k);
		    h.add(ss);
            if(h.size()==total)return true;
		}
        /*for(int i=0;i<al.size();i++){
            if(!h.contains(al.get(i)))return false;
        }
        */
        return false;
    }
    
   /* public static ArrayList<String> gss(int n) {
        if(n==0)
        {
            ArrayList<String> myAl = new ArrayList<>();
            myAl.add("");
            return myAl;
        }
        ArrayList<String> faithAl = gss(n-1);
        ArrayList<String> myAl = new ArrayList<>();
        for(String s: faithAl)
        {
            myAl.add('0'+s);
        }
         for(String s: faithAl)
        {
            myAl.add('1'+s);
        }  
        return myAl;
    }
    */
}