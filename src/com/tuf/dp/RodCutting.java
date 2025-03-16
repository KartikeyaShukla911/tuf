package com.tuf.dp;

import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,3,5,6,17,20};
		
		int n = arr.length;
		
		int[][] dp = new int [n][n+1];
		
		for(int[] row : dp)
		{
			Arrays.fill(row, -1);
		}
		
		System.out.println("Max rod-cut val"+rodCut(arr,arr.length,dp));
	}

	public static int rodCut(int[] arr,int n,int[] dp)
	{
		if(n<=0)
			return 0;
		
		if(dp[n-1]!=-1)
			return dp[n-1];
		
		int ans = 0;
		int i;
		for(i=1;i<n;i++)
		{
			ans = Math.max(ans, arr[i-1] + rodCut(arr,n-i,dp));
		}
		return dp[n-1]=ans;
	}
	
	/*tabulation*/
	
	public static int rc(int[] arr,int n)
	{
		int dp[] = new int[n+1];
		int i,j;
		
		for(i=1;i<n;i++)
		{
			for(j=0;j<=i;j++)
			{
				dp[i] = Math.max(dp[i], arr[i-1] + dp[i-j]);
			}
		}
		return dp[n];
	}
	
	
}
