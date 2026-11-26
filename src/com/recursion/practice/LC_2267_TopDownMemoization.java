package com.recursion.practice;

import java.util.Arrays;

public class LC_2267_TopDownMemoization {
    private int m,n;
    private int[][][] memo;
    public static void main(String[] args) {
        char[][] grid = {{'(','(','('},{')',')','('},{'(','(',')'},{'(','(',')'}};
        System.out.println(new LC_2267_TopDownMemoization().hasValidPath(grid));
    }
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;//rows
        n = grid[0].length;//columns
        int maxLength = m + n - 1;//WKT a Valid Parentheses String is always of even length...
        if((maxLength & 1) == 1) return false;
        if(grid[0][0] == ')' || grid[m-1][n-1] == '(') return false;
        memo = new int[m][n][maxLength + 1];//initializing memo
        for(int[][] arr2D:memo){
            for(int[] arr1D:arr2D){
                Arrays.fill(arr1D,-1);
            }
        }
        return solve(0,0,0,grid);
    }
    private boolean solve(int i, int j,int openCount,char[][] grid){
        openCount += (grid[i][j] == '(') ? 1 : -1;
        if(openCount < 0) return false; //Impossible to balance
        if(i == m-1 && j == n-1) return (openCount == 0);
        if (memo[i][j][openCount] != -1) {
            return memo[i][j][openCount] == 1;
        }
        boolean result = false;
        //Move down.
        if(i+1 < m){
            if(solve(i+1,j,openCount,grid)){
                result = true;
            }
        }
        //Move right.
        if(!result && j+1 < n){
            if(solve(i,j+1,openCount,grid)){
                result = true;
            }
        }
        memo[i][j][openCount] = result ? 1 : 0;
        return result;
    }
}
