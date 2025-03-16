package com.tuf.dp;

public class KnapsackUnbound {
	
	/*
	 * memoize sol
	 */
	public static int unBoundKnap(int[] wt, int[] val, int n,int W,int dp[][])
	{
		if(n==0)
		{
			return (int)(W/wt[0] * val[0]);
		}
		
		if(dp[n][W]!=-1)
			return dp[n][W];
		
		int take=Integer.MIN_VALUE;
		
		//not take;
		
		int notTake = 0 + unBoundKnap(wt,val,n-1,W,dp);
		
		if(wt[n-1] < W)
		{
			take = val[n-1] + unBoundKnap(wt,val,n,W-wt[n-1],dp);
		}
		
		dp[n][W] = Math.max(take, notTake);
		return dp[n-1][W];
	}
	
	/*memo unbound knapsack*/
	
	public static int unboundKnap(int[] wt,int[] val,int n,int W,int dp[][])
	{
		if(n==0)
		{
			return (int)(W/wt[n] * val[n]);
		}
		
		if(dp[n][W]==-1)
			return dp[n][W];
		
		int notTake = unboundKnap(wt,val,n-1,W,dp);
		int take = Integer.MAX_VALUE;
		
		if(wt[n]<=W)
		{
			take = val[n] + unboundKnap(wt,val,n,W-val[n-1],dp); 
		}
		
		return dp[n][W] = Math.max(take,notTake);
		
	}
	
	/*
	 * tabulation knapsack
	 */
	
	public static int knapsack(int wt[],int val[],int n,int W)
	{
		int dp[][] =new int[n][W+1];
		int i;
		
		int j;
		for(i=wt[0];i<=W;i++)
		{
			dp[0][i] = (int)( i/wt[0] * val[0]);
		}
		
		for(i=1;i<n;i++)
		{
			for(j=0;j<=W;j++)
			{
				int notTake = 0 + dp[i-1][j];
				int take = Integer.MIN_VALUE;
				if(wt[i]<=j)
				{
					take = dp[i][j - wt[i]];
				}
				
				dp[i][j] = Math.max(notTake, take);
			}
		}
		return dp[n-1][W];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
