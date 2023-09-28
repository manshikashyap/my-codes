//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            int arr[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (int i = 0; i < N; i++) {
                    arr[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBalloons(N, arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int mostBalloons(int n, int arr[][]) {
        // Code here
        int ans=0;
        for(int i=0;i<n;i++){
            int x1=arr[i][0];
            int y1=arr[i][1];
            HashMap<Double,Integer> hm=new HashMap<>();
            int count=0;
            for(int j=0;j<n;j++){
                int x2=arr[j][0];
                int y2=arr[j][1];
                if(x1==x2 && y1==y2){
                    count++;
                    continue;
                }else{
                    double slope=(y2-y1)/((x2-x1)*1.0);
                    if(hm.containsKey(slope)){
                        hm.put(slope,hm.get(slope)+1);
                    }
                    else{
                        hm.put(slope,1);
                    }
                }
            }
            for(double d:hm.keySet()){
                ans=Math.max(ans,hm.get(d)+count);
            }
        }
        return ans;
    }
}



