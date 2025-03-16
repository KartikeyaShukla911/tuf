package com.tuf.dp2;

public class MinPathSum {

	public static int minPathSum(int[][] arr,int n,int m,int dp[][])
	{
		if(n==0 && m==0)
			return arr[0][0];
		
		if(n==0 || m==0)
			return Integer.MIN_VALUE;
		
		if(dp[n][m]!=-1)
			return dp[n][m];
		
		int up = arr[n][m]+ minPathSum(arr,n-1,m,dp);
		int left = arr[n][m] + minPathSum(arr,n,m-1,dp);
		
		return dp[n][m] = Math.min(up, left);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
