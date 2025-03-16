package com.tuf.dp;

import java.util.Arrays;

public class Knapsack01 {
	
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
