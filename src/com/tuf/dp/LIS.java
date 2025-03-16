package com.tuf.dp;

import java.util.Arrays;

public class LIS {
	
	public static int LIS(int arr[],int n ,int idx,int prev,int[][] dp)
	{
		if(idx>=n)
			return 0;
		if(dp[idx][prev+1]!=-1)
			return dp[idx][prev+1];
		
		int untake = 0 + LIS(arr,n,idx+1,prev,dp);
		int take=0;
		if(prev==-1 ||  arr[idx] > arr[prev])
		{
			take = 1 + LIS(arr,n,idx+1,idx,dp);
		}
		dp[idx][prev+1] = Math.max(untake, take);
		return dp[idx][prev+1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dp[][] = new int[4][4];
		for(int i=0;i<4;i++)
			Arrays.fill(dp[i], -1);
	}

}
