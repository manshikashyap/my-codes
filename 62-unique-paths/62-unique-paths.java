class Solution {
    int ans =0;
    public int uniquePaths(int m, int n) {
      /*if(m==1 && n==1){
           ans++;
           return ans;
       }   
        if(m>1)
        ans = uniquePaths(m-1,n);
        if(n>1)
        ans =uniquePaths(m,n-1);
           
           return ans;
          
       /* if(m==1)return 1;
        int sum =0;
        for(int i =0;i<n;++i){
            sum+= uniquePaths(m-1,n-i);
        }
        return sum;
        */
        
        
          if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
    }
}