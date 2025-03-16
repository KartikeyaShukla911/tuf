package com.tuf.dp2;

public class EggDropping {
	
	
	/*
	 * k is floor
	 * n is eggs
	 */
	public static int eggdp(int k, int n)
	{
		if(k<=1)
			return k;
		
		if(n<=0)
			return 0;
		
		if(n==1)
			return k;
		
		int i,j;
		
		int ans = Integer.MAX_VALUE;
		
		for(i=1;i<=k;i++)
		{
			int tmp = 1 + Math.min(eggdp(i-1,n-1), eggdp(k-i,n));
			ans = Math.min(ans, tmp);
		}
		return ans;
	}
	
	public static int eggD(int k,int n , int dp[][])
	{
		if(k<=1)
			return k;
		
		if(n==1)
			return k;
		if(n<=0)
			return 0;
		
		if(dp[n][k]!=-1)
			return dp[n][k];
		
		for(int i=1;i<=k;i++)
		{
			int tmp = 1 + Math.min(eggdp(i-1,n-1), eggdp(k-i,n));
			dp[n][i] = Math.min(dp[n][i], tmp);
		}
		return dp[n][k];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
