//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    for(int t=1;t<=9;t++){
                        if(isvalid(grid,i,j,t)){
                            grid[i][j]=t;
                            if(SolveSudoku(grid)){
                                return true;
                            }
                            else{
                                grid[i][j]=0;
                            }
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static boolean isvalid(int grid[][],int r,int c,int t){
        for(int i=0;i<9;i++){
            if(grid[r][i]==t)return false;
            if(grid[i][c]==t)return false;
            if(grid[3*(r/3)+i/3][3*(c/3)+i%3]==t)return false;
        }
       
        return true;
    }
    
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}