class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        if(divisor ==1||divisor == -1)return dividend*divisor;
        int c=0;
        int d=Math.abs(divisor);
        int di=Math.abs(dividend);
        while(di-d>=0){
            di=di-d;
            c++;
        }
        if((divisor<0 && dividend>0)|| divisor>0 && dividend<0)c=0-c;
        if(c>(int)Math.pow(2,31)-1)return (int)Math.pow(2,31)-1;
        if(c<0-(int)Math.pow(2,31))return 0-(int)Math.pow(2,31)-1;
       
        return c;
    }
}