package com.tuf.dp2;

public class CoinChange {
	
	public static int coinChange(int[] arr,int n,int tar)
	{
		if(n==0)
		{
			if(arr[0]<=tar)
			{
				return tar/arr[0];
			}
			else
				return 0;
		}
		
		if(tar==0)
			return 0;
		
		int notTake = coinChange(arr,n-1,tar);
		int take=0;
		
		if(arr[n-1]<=tar)
		{
			take = 1 + coinChange(arr,n-1,tar-arr[n-1]);
		}
		return notTake + take;
	}
	
	public static int coinChangeDp(int[] arr,int n,int tar,int[][] dp)
	{
		if(n==0)
		{
			if(arr[0]<=tar)
			{
				return tar/arr[0];
			}
			else
				return 0;
		}
		
		if(tar==0)
			return 0;
		
		if(dp[n][tar]!=-1)
			return dp[n][tar];
		
		int notTake = coinChangeDp(arr,n-1,tar,dp);
		int take=0;
		if(arr[n-1]<=tar)
		{
			take = 1 + coinChangeDp(arr,n-1,tar-arr[n-1],dp);
		}
		return dp[n][tar]=take+notTake;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
