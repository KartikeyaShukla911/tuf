package com.tuf.arrays.misc;

public class GrdiUniquePath {
	
	/*
	 * O(2^n)
	 * 
	 */
	public static int gridPath(int n,int m)
	{
		if(n==0 && m==0)
			return 1;
		if(n<0 || m<0)
			return 0;
		return gridPath(n-1,m) + gridPath(n,m-1);
	}
	
	/*
	 * O(n2)
	 */
	public static int dpgrid(int n,int m,int[][] dp)
	{
		if(n==0 && m==0)
			return 1;
		if(n<0 || m<0)
			return 0;
		
		if(dp[n][m]!=-1)
			return dp[n][m];
		return dpgrid(n-1,m,dp) + dpgrid(n,m-1,dp);
	}
	
	public static int dpgridOp(int n,int m,int[][] dp)
	{
		for(int i=0;i<n;i++)
		{
			dp[i][0]=1;
			dp[0][i]=1;
		}
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<n;j++)
			{
				dp[i][j]=dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[n-1][m-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
