package com.tuf.dp;

import java.util.Arrays;

public class EditDistance {
	
	public static int editDistance(String s1,String s2)
	{
		/*
		 * min operations requ. to insert, replace or delete from s1 ==> s2
		 */
		
		int n = s1.length(),m=s2.length();
		
		int dp[][] = new int[n+1][m+1];
		for(int[] row : dp)
		{
			Arrays.fill(row, -1);
		}
		
		return util(s1,s2,n,m,dp);
		
	}
	
	public static int util(String s1,String s2,int n,int m, int[][] dp)
	{
		if(n<0)
			return m+1;
		if(m<0)
			return n+1;
		
		if(dp[n][m]!=-1)
			return dp[n][m];
		
		if(s1.charAt(n-1)==s2.charAt(m-1))
		{
			dp[n-1][m-1] = util(s1,s2,n-1,m-1,dp);
		}
		else
		{
			dp[n-1][m-1] = 1 + Math.min(util(s1,s2,n-1,m-1,dp), Math.min(util(s1,s2,n-1,m,dp), util(s1,s2,n,m-1,dp)));
		}
		return dp[n][m];
	}
	
	/*
	 * n2,
	 * n2 + n
	 */
	
	public static int editTab(String s1,String s2,int n,int m)
	{
		int dp[][] = new int[n+1][m+1];
		
		int i,j;
		for(i=0;i<n;i++)
		{
			dp[i][0] = i;
		}
		
		for(j=0;j<m;j++)
		{
			dp[0][j] = j;
		}
		
		for(i=1;i<n;i++)
		{
			for(j=1;j<m;j++)
			{
				if(s1.charAt(i)==s2.charAt(j))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					dp[i][j] =  1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				}
			}
		}
		return dp[n][m];
	}
	
	/*
	 * n2
	 * s2
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
