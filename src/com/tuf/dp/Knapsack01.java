package com.tuf.dp;

import java.util.Arrays;

public class Knapsack01 {
	
	/*
	 * O N x W
	 * S N x W + O N
	 */
	public static void knapsack(int[] value,int W)
	{
		int n = value.length;
		int dp[][] = new int[n+1][W+1];
		
		int i;
		for(i=0;i<=n;i++)
		{
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println("max wt-value: "+knapsackUtil(value,n-1,W,dp));
	}
	
	public static int knapsackUtil(int[] value,int n,int W,int[][] dp)
	{
		if(n==0)
		{
			if(value[0]<=W)
				return value[0];
			else
				return 0;
		}
		
		if(dp[n][W]!=-1)
			return dp[n][W];
		
		int notTake = 0 + knapsackUtil(value,n-1,W,dp);
		int take = Integer.MIN_VALUE;
		
		if(value[n]<=W)
		{
			take = value[n-1] + knapsackUtil(value,n-1,W-value[n-1],dp);
		}
		
		dp[n][W] = Math.max(notTake, take);
		return dp[n][W];
	}
	
	/*
	 * O N x W
	 * S N x W
	 */
	static int knapsack(int[] wt, int[] val, int n, int W) {
        // Create a 2D DP array to store the maximum value for each subproblem
        int dp[][] = new int[n][W + 1];
        
        // Base Condition
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }
        
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = dp[ind - 1][cap];
                
                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + dp[ind - 1][cap - wt[ind]];
                }
                
                // Store the maximum value for the current state
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }
        
        // The result is stored in the last row and last column of the DP array
        return dp[n - 1][W];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
