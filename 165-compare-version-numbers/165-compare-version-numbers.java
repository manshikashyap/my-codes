class Solution {
    public int compareVersion(String v1, String v2) {
        String v1l[]=v1.split("\\.");
        String v2l[]=v2.split("\\.");
        int l1=v1l.length;
        int l2=v2l.length;
        int i=0,j=0;
        while(i<l1 && j<l2){
            int val1=Integer.parseInt(v1l[i]);
            int val2=Integer.parseInt(v2l[j]);
            i++;
            j++;
            if(val1<val2)return -1;
            if(val1>val2)return 1;
           
        }
        while(i<l1){
            int val1=Integer.parseInt(v1l[i]);
            i++;
            if(val1>0)return 1;
        }
        while(j<l2){
            int val2=Integer.parseInt(v2l[j]);
            j++;
            if(val2>0)return -1;
        }
        return 0;
    }
}