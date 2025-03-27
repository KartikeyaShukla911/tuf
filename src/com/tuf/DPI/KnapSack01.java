package com.tuf.DPI;

public class KnapSack01 {
	
	public static int knapSack(int[] wt,int val[],int W,int n,int dp[][])
	{
		if(n==0)
		{
			if(wt[n]<=W)
				return val[n];
			return 0;
		}
		if(dp[n][W]!=-1)
			return dp[n][W];
		
		int pick=Integer.MIN_VALUE;
		if(wt[n]<=W)
		{
			dp[n][W]= knapSack(wt,val,W-wt[n-1],n-1,dp) + val[n-1];
		}
		
		int notPick = knapSack(wt, val, W, n-1, dp);
		return dp[n][W]= Math.max(pick, notPick);
	}
	/*
	 * O N x W
	 * O NxW + O N
	 */
	
	static int knapsack(int[] wt,int[] val,int n,int W)
	{
		//Util helper
		int dp[][] = new int[n][W+1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
